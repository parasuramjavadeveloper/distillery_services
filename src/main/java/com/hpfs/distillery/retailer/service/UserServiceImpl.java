package com.hpfs.distillery.retailer.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hpfs.distillery.retailer.dto.PermissionsDto;
import com.hpfs.distillery.retailer.dto.RolePermissionsDto;
import com.hpfs.distillery.retailer.dto.RolesDto;
import com.hpfs.distillery.retailer.dto.UserChangePwd;
import com.hpfs.distillery.retailer.dto.UserRolesDto;
import com.hpfs.distillery.retailer.model.TblPermissions;
import com.hpfs.distillery.retailer.model.TblRoleMapping;
import com.hpfs.distillery.retailer.model.TblRoles;
import com.hpfs.distillery.retailer.model.TblUserPermissions;
import com.hpfs.distillery.retailer.model.TblUsers;
import com.hpfs.distillery.retailer.repository.TblPermissonsRepository;
import com.hpfs.distillery.retailer.repository.TblRolesRepository;
import com.hpfs.distillery.retailer.repository.UserPermissons;
import com.hpfs.distillery.retailer.repository.UsersRepository;
import com.hpfs.distillery.retailer.repository.UsersRolesMappingRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;
import com.hpfs.distillery.retailer.utils.DateUtils;
import com.hpfs.distillery.retailer.utils.GenerationOTP;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UsersRepository usersRepository;
	
	@Resource
	UserPermissons userPermissons;
	
	@Resource
	UsersRolesMappingRepository usersRolesMappingRepository;
	
	@Resource
	TblRolesRepository tblRolesRepository;
	
	@Resource
	TblPermissonsRepository tblPermissonsRepository;
	
	@Override
	public Long isUserExists(String userName) {
		TblUsers tblUsers = usersRepository.findByUserNameAndStatus(userName, ApplicationConstants.ACTIVE_STATUS);
		if(null!=tblUsers) {
			return 1L;
		}else {
			return 0L;
		}
	}
	
	@Override
	public UserRolesDto login(String userName,String password) {
		UserRolesDto userRolesDto =null;
		
		TblUsers tblUsers =usersRepository.findByUserNameAndPasswordAndStatus(userName, password,ApplicationConstants.ACTIVE_STATUS);
		if(tblUsers!=null && tblUsers.getUserId()!=0) {
			userRolesDto = this.fetchUserRolePermByUserId(tblUsers);
		}
		 
		 return userRolesDto;
	}
	
	@Override
	@Transactional
	public TblUsers userMlogin(String userName,String password) {
		List<TblUserPermissions> userPermissionsList =null;
		TblUsers tblUsersDts = new TblUsers();
		TblUsers tblUsers =usersRepository.findByUserNameAndPasswordAndStatus(userName, password,ApplicationConstants.ACTIVE_STATUS);
		if(tblUsers!=null && tblUsers.getUserId()!=0) {
			//Sending directly OTP to the registired mobile number
			String otp = GenerationOTP.generateOTP(ApplicationConstants.OTP_LENGTH);
			tblUsers.setOtp(Long.valueOf(otp));
			String s =sendOtpSMS(otp.toString(), tblUsers.getMobileNumber().toString());
			if(s!=null && !StringUtils.isEmpty(s) && ! s.contains("Error")) {
				tblUsers = usersRepository.save(tblUsers);
				tblUsersDts.setUserId(tblUsers.getUserId());
				tblUsersDts.setOtp(tblUsers.getOtp());
				return tblUsersDts;
			}
			//userPermissionsList = userPermissons.fetchAllPermissionByUserId(tblUsers.getUserId());
		}
		 
		 return tblUsersDts;
	}
	
	public String saveOrUpdateUserRolesMap(UserRolesDto requestData) {
		String msg="";
		TblUsers userDts = null;
		int count =0;
		try {
				if(requestData.getUserId() == null) {
				TblUsers user = new TblUsers();
				user.setUserName(requestData.userName);
				user.setFirstName(requestData.getFirstName());
				user.setLastName(requestData.getLastName());
				user.setEmailId(requestData.getEmailId());
				user.setPassword(requestData.getPassword());
				user.setMobileNumber(requestData.getMobileNumber());
				user.setStatus(ApplicationConstants.ACTIVE_STATUS);
				user.setCreationDate(DateUtils.DateToString());
				user.setCreatedBy("ADMIN");
				userDts= usersRepository.save(user);
				List<TblRoleMapping> roleMapList = new ArrayList<>();
				if(null!=userDts && userDts.getUserId()!=0 && null!=requestData.getRoleIds() && requestData.getRoleIds().size()>0){
					for(Long roleId:requestData.getRoleIds()) {
						TblRoleMapping roleMap = new TblRoleMapping();
						roleMap.setUserId(userDts.getUserId());
						roleMap.setRoleId(roleId);
						roleMap.setStatus(ApplicationConstants.ACTIVE_STATUS);
						roleMap.setCreationDate(DateUtils.DateToString());
						roleMap.setCreatedBy("ADMIN");
						TblRoleMapping roleMapDts  = usersRolesMappingRepository.save(roleMap);
						if(roleMapDts!=null) {
							count++;
						}
						
					}
				}
				
				if(null!=userDts && userDts.getUserId()!=0 && null!=requestData.getRolesList() && requestData.getRolesList().size()>0) {
					for(RolesDto roleDto:requestData.getRolesList()) {
						TblRoleMapping roleMap = new TblRoleMapping();
						roleMap.setUserId(userDts.getUserId());
						roleMap.setRoleId(roleDto.getRoleId());
						roleMap.setStatus(ApplicationConstants.ACTIVE_STATUS);
						roleMap.setDescription(roleDto.getRoleName());
						roleMap.setCreationDate(DateUtils.DateToString());
						roleMap.setCreatedBy("ADMIN");
						TblRoleMapping roleMapDts  = usersRolesMappingRepository.save(roleMap);
						if(roleMapDts!=null) {
							count++;
						}
						
					}
				}
			}else {
				//update tblUsers
				if(requestData.getUserId()!=null && requestData.getUserId()>0) {
					TblUsers tblUsers = usersRepository.findByUserId(requestData.getUserId());
					TblUsers userUpdateDts = new TblUsers();
					if(tblUsers!=null) {
						tblUsers.setUserName(requestData.userName);
						tblUsers.setFirstName(requestData.getFirstName());
						tblUsers.setLastName(requestData.getLastName());
						tblUsers.setEmailId(requestData.getEmailId());
						tblUsers.setPassword(requestData.getPassword());
						tblUsers.setMobileNumber(requestData.getMobileNumber());
						tblUsers.setStatus(ApplicationConstants.ACTIVE_STATUS);
						tblUsers.setUpdatedDate(DateUtils.DateToString());
						tblUsers.setUpdatedBy("ADMIN");
						userUpdateDts= usersRepository.save(tblUsers);
						List<TblRoleMapping> roleMapList = new ArrayList<>();
						if(null!=userUpdateDts && userUpdateDts.getUserId()!=0 && null!=requestData.getRoleIds() && requestData.getRoleIds().size()>0) {
							List<TblRoleMapping> roleList = usersRolesMappingRepository.findByUserId(userUpdateDts.getUserId());
							if(roleList!=null) {
								usersRolesMappingRepository.deleteInBatch(roleList);
							}
							for(Long roleId:requestData.getRoleIds()) {
								TblRoleMapping roleMap = new TblRoleMapping();
								roleMap.setUserId(userUpdateDts.getUserId());
								roleMap.setRoleId(roleId);
								roleMap.setStatus(ApplicationConstants.ACTIVE_STATUS);
								//roleMap.setDescription(roleDto.getRoleName());
								roleMap.setCreationDate(DateUtils.DateToString());
								roleMap.setCreatedBy("ADMIN");
								TblRoleMapping roleMapDts  = usersRolesMappingRepository.save(roleMap);
								if(roleMapDts!=null) {
									count++;
								}
							}
						}
						
					}
				}
				
			}
		if(count==(requestData.getRoleIds().size())) {
			msg ="SUCCESSFULLY created/updated User Role Mapping";
		}
		}catch(Exception e) {
			e.printStackTrace();
			return msg ="Error in While Add/Update in User Role Permissions Dts";
		}
		return msg;
	}
	
	@Override
	@Transactional
	public String saveRolePermissions(RolePermissionsDto requestData) {
		String msg ="FAILURE";
		int count =0;
		Long createdRoleId=null;
		try {
			if(requestData.getRoleId()!=null) {
				//update role dts
				TblRoles role = tblRolesRepository.findByRoleId(requestData.getRoleId());
				if(role!=null) {
					role.setRoleName(requestData.getRoleName());
					role.setUpdatedBy("ADMIN");
					role.setUpdatedDate(DateUtils.DateToString());
					role.setRoleType(requestData.getRoleType());
					role.setDescription(requestData.getRoleDescription());
					TblRoles updatedRole = tblRolesRepository.save(role);
					if(updatedRole!=null) {
						List<TblPermissions> permList = tblPermissonsRepository.findByRoleId(requestData.getRoleId());
						if(permList!=null) {
							//delete
							tblPermissonsRepository.deleteInBatch(permList);//deletePermissionsByRoleId(requestData.getRoleId());
						}
						if(requestData.getPermissionsList()!=null && requestData.getPermissionsList().size()>0) {
							for(PermissionsDto p:requestData.getPermissionsList()) {
								TblPermissions per = new TblPermissions();
								per.setPath(p.getPath());
								per.setIsEdit(p.getIsEdit());
								per.setIsView(p.getIsView());
								per.setIsDelete(p.getIsDelete());
								per.setIsAdd(p.getIsAdd());
								per.setRoleId(requestData.getRoleId());
								TblPermissions permissions = tblPermissonsRepository.save(per);
								if(permissions!=null) {
									count++;
								}
							}
							
						}
					}
				}
				else
				{
					msg="Role id given in the request "+requestData.getRoleId()+" doesn't exist. Send existing role id or send roleId as null if it doesn't exist.";
					return msg;
				}
			}else if(null== requestData.getRoleId()||requestData.getRoleId()==0) {
				//creating new Role
				TblRoles role = new TblRoles();
				role.setRoleName(requestData.getRoleName());
				role.setRoleType(requestData.getRoleType());
				role.setDescription(requestData.getRoleDescription());
				role.setStatus(ApplicationConstants.ACTIVE_STATUS);
				role.setCreationDate(DateUtils.DateToString());
				role.setCreatedBy("ADMIN");
				TblRoles r = tblRolesRepository.save(role);
				System.out.println("Created Role, roleId "+ r.getRoleId());
				if(r!=null) {
					if(requestData.getPermissionsList()!=null && requestData.getPermissionsList().size()>0) {
						for(PermissionsDto p:requestData.getPermissionsList()) {
							TblPermissions per = new TblPermissions();
							per.setPath(p.getPath());
							per.setIsEdit(p.getIsEdit());
							per.setIsView(p.getIsView());
							per.setIsDelete(p.getIsDelete());
							per.setIsAdd(p.getIsAdd());
							per.setRoleId(r.getRoleId());
							TblPermissions permissions = tblPermissonsRepository.save(per);
							System.out.println("Created RolePermission, permissions "+ permissions.getRoleId());
							createdRoleId=permissions.getRoleId();
							if(permissions!=null) {
								count++;
							}
						}
						
				}
				
				}
			}
			
			if(count==requestData.getPermissionsList().size()) {
				msg="SUCCESSFULLY Role Permissions created with role id "	+createdRoleId;
			}
		}catch(Exception e) {
			e.printStackTrace();
			msg="FAILURE while role based Permissions creation";
		}
		return msg;
	}

	
	@Override
	public TblUsers validateEmailNum(String emailOrNum) {
		TblUsers tblUser = new TblUsers();
		if (emailOrNum.matches("[0-9]+") && emailOrNum.length() > 8) {
			TblUsers tblUser1 = usersRepository.findByMobileNumber(Long.valueOf(emailOrNum));
			tblUser.setUserId(tblUser1.getUserId());
	    }else if(emailOrNum.matches(ApplicationConstants.emailRegex)) {
	    	TblUsers tblUser2 = usersRepository.findByEmailId(emailOrNum);
	    	tblUser.setUserId(tblUser2.getUserId());
	    }
		return tblUser;
	}

	@Override
	@Transactional
	public TblUsers generateOTP(Long userId, String emailOrNum) {
		TblUsers tbluser = new TblUsers();
		int l =0;
		String otp =GenerationOTP.generateOTP(ApplicationConstants.OTP_LENGTH);
		if (emailOrNum.matches("[0-9]+") && emailOrNum.length() > 8) {
			tbluser =usersRepository.findByUserIdAndMobileNumber(userId, Long.valueOf(emailOrNum));
			if(null!=tbluser && tbluser.getUserId()>0) {
				tbluser.setPassword(otp);
				l=usersRepository.updateByUserId(tbluser.getPassword(),tbluser.getUserId());
				if(l!=0) {
				}
				String s =sendOtpSMS(otp, emailOrNum);
				if(s!=null && !StringUtils.isEmpty(s) && ! s.contains("Error")) {
					return tbluser;
				}
			}else {
				return new TblUsers();
			}
		}else if(emailOrNum.matches(ApplicationConstants.emailRegex)) {
			tbluser =usersRepository.findByUserIdAndEmailId(userId, emailOrNum);
			if(null!=tbluser && tbluser.getUserId()>0) {
				tbluser.setPassword(otp);
				l=usersRepository.updateByUserId(tbluser.getPassword(),tbluser.getUserId());
				if(l!=0) {
					String s =sendOtpSMS(otp, emailOrNum);
					if(s!=null && !StringUtils.isEmpty(s) && ! s.contains("Error")) {
						return tbluser;
					}
				}
			}else {
				return new TblUsers();
			}
		}
		return tbluser;
	}
	
	public static String sendOtpSMS(String OTP,String mobileNumber) {
		HttpURLConnection conn = null;
		final StringBuffer stringBuffer = new StringBuffer();
		try {
			// Construct data
			String apiKey = "apikey=" + ApplicationConstants.SMSKEY;//"Pw+d0E9Vexg-BKHcfcSEdGMg65bVyqbpYjf90mGk5V";
			String message = "&message="+OTP+ApplicationConstants.SMS_MSG;
			//+ ApplicationConstants.BLUE_BOLD+OTP+ApplicationConstants.ANSI_RESET+ApplicationConstants.SMS_MSG;
			String sender = "&sender=" +ApplicationConstants.SMS_SENDER;
			String numbers = "&numbers=" + mobileNumber;
			
			conn = (HttpURLConnection) new URL(ApplicationConstants.SMS_URL).openConnection();
			String data = apiKey + numbers + message + sender;
			conn.getURL();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			conn.connect();
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			conn.disconnect();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			conn.disconnect();
			return "Error "+e;
		}
	}

	@Override
	@Transactional
	public String createNewPwd(UserChangePwd requestData) {
		String msg="";
		if(null!=requestData) {
				TblUsers tblUsers=usersRepository.findByUserIdAndPassword(requestData.getUserId(), requestData.getOtp().trim());
				if(null!=tblUsers) {
					int userId =usersRepository.updateByUserId(requestData.getNewPwd(),requestData.getUserId());
					if(userId!=0) {
						return msg="SUCCESSFULLY New Password Created";
					}else {
						return msg="Error While Creating New Password";
					}
				}else {
					return msg="OTP Entired is Wrong,please regeneate OTP again";
				}
		}
		return msg;
	}
	
	@Override
	@Transactional
	public String changePwd(UserChangePwd requestData) {
		String msg="";
		if(null!=requestData) {
				TblUsers tblUsers=usersRepository.findByUserIdAndPassword(requestData.getUserId(), requestData.getOldPwd().trim());
				if(null!=tblUsers) {
					int userId =usersRepository.updateByUserId(requestData.getNewPwd(),requestData.getUserId());
					if(userId!=0) {
						return msg="SUCCESSFULLY Your Password has Changed";
					}else {
						return msg="Old Password Doesn't Match in DB";
					}
				}else {
					return msg="Please Enter Old Password Currectly";
				}
		}
		return msg;
	}

	@Override
	public List<TblRoles> fetchActiveRoles() {
		return tblRolesRepository.findAllByStatus(ApplicationConstants.ACTIVE_STATUS);
	}
	
	@Override
	public List<TblUsers> fetchActiveUsers() {
		List<TblUsers>  tbluserList =usersRepository.findAllByStatus(ApplicationConstants.ACTIVE_STATUS);
		for(TblUsers tblUser:tbluserList)
		{
			if(tblUser.getUserId() != null)
			{
				List<TblRoleMapping> list = usersRolesMappingRepository.findByUserId(tblUser.getUserId());
				tblUser.setRolesList(list);
			}
		}
		
		return tbluserList;
	}

	@Override
	@Transactional
	public TblUsers updateUserDts(TblUsers requestData) {
		TblUsers user=null;
		try {
			if(requestData!=null && requestData.getUserId()!=null) {
				user = usersRepository.findByUserId(requestData.getUserId());
				
				user.setUserName(requestData.getUserName());
				user.setFirstName(requestData.getFirstName());
				user.setLastName(requestData.getLastName());
				user.setEmailId(requestData.getEmailId());
				user.setMobileNumber(requestData.getMobileNumber());
				user.setPassword(requestData.getPassword());
				user.setUpdatedDate(DateUtils.DateToString());
				user = usersRepository.save(user);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<TblUserPermissions> userOTPLogin(TblUsers requestData) {
		List<TblUserPermissions> userPermissionsList =null;
		
		TblUsers tblUsers =usersRepository.findByUserIdAndOtpAndStatus(requestData.getUserId(),requestData.getOtp(),ApplicationConstants.ACTIVE_STATUS);
		if(tblUsers!=null && tblUsers.getUserId()!=0) {
			userPermissionsList = userPermissons.fetchAllPermissionByUserId(tblUsers.getUserId());
		}
		 return userPermissionsList;
	}

	@Override
	@Transactional
	public TblUsers loginWithMobile(TblUsers requestData) {
		TblUsers tblUsersDts = new TblUsers();
		com.hpfs.distillery.retailer.model.TblUsers tblUsers =usersRepository.findByMobileNumberAndStatus(requestData.getMobileNumber(),ApplicationConstants.ACTIVE_STATUS);
		if(tblUsers!=null && tblUsers.getUserId()!=0) {
			//Sending directly OTP to the registired mobile number
			String otp = GenerationOTP.generateOTP(ApplicationConstants.OTP_LENGTH);
			tblUsers.setOtp(Long.valueOf(otp));
			String s =sendOtpSMS(otp.toString(), tblUsers.getMobileNumber().toString());
			if(s!=null && !StringUtils.isEmpty(s) && ! s.contains("Error")) {
				tblUsers = usersRepository.save(tblUsers);
				tblUsersDts.setUserId(tblUsers.getUserId());
				tblUsersDts.setOtp(tblUsers.getOtp());
				return tblUsersDts;
			}
		}
		return tblUsersDts;
	}

	@Override
	public UserRolesDto fetchUserRolePermByUserId(TblUsers requestData) {
		UserRolesDto dto = new UserRolesDto();
		TblUsers user=new TblUsers();
		try {
			if(requestData!=null && requestData.getUserId()!=null) {
				user = usersRepository.findByUserIdAndStatus(requestData.getUserId(),ApplicationConstants.ACTIVE_STATUS);
				if(user!=null) {
					dto.setUserName(user.getUserName());
					dto.setFirstName(user.getFirstName());
					dto.setLastName(user.getLastName());
					dto.setEmailId(user.getEmailId());
					dto.setMobileNumber(user.getMobileNumber());
					dto.setPassword(user.getPassword());
					dto.setUserId(user.getUserId());
					dto.setFavourites(user.getFavourites());
					List<RolesDto> rolesDtoList = new ArrayList<>();
					List<TblRoleMapping> list = usersRolesMappingRepository.findByUserId(requestData.getUserId());
					if(list!=null && list.size()>0) {
						for(TblRoleMapping roleMapping: list) {
							RolesDto rolesDto = new RolesDto();
							TblRoles role = tblRolesRepository.findByRoleId(roleMapping.getRoleId());
							if(role!=null) {
								rolesDto.setRoleId(role.getRoleId());
								rolesDto.setRoleName(role.getRoleName());
								rolesDto.setStatus(role.getStatus());
								List<TblPermissions> permList = tblPermissonsRepository.findByRoleId(role.getRoleId());
								if(permList!=null && permList.size()>0) {
									List<PermissionsDto> permDtoList = new ArrayList<>();
									for(TblPermissions p:permList) {
										PermissionsDto pDto = new PermissionsDto();
										pDto.setIsAdd(p.getIsAdd());
										pDto.setIsDelete(p.getIsDelete());
										pDto.setIsEdit(p.getIsEdit());
										pDto.setIsView(p.getIsView());
										pDto.setPath(p.getPath());
										pDto.setPermissionId(p.getPermissionId());
										pDto.setRoleId(p.getRoleId());
										permDtoList.add(pDto);
									}
									rolesDto.setPermissionsList(permDtoList);
								}
								rolesDtoList.add(rolesDto);
								
							}
						}
						dto.setRolesList(rolesDtoList);
					}
					//dto.setRolesList(rolesDtoList);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<TblPermissions> fetchPermissionByRoleId(Long roleId) {
		return tblPermissonsRepository.findByRoleId(roleId);
	}

	@Override
	public List<TblPermissions> fetchAllPermissionsDts() {
		return tblPermissonsRepository.findAll();
	}

	@Override
	@Transactional
	public String spLastLogin(TblUsers requestData) {
		TblUsers users = new TblUsers();
		 int lastLoginTime = usersRepository.sp_last_login(requestData.userId);
		 if(lastLoginTime!=0) {
			 users =  usersRepository.findByUserId(requestData.userId);
		 }
		return users.getLastLoginTime();
	}

	@Override
	public TblUsers fetchUserDtsByUserId(TblUsers requestData) {
		return usersRepository.findByUserId(requestData.userId);
	}

	@Override
	@Transactional
	public String spLastLoginForWeb(TblUsers requestData) {
		String msg="";
		 int lastLoginTime = usersRepository.sp_last_login(requestData.userId);
		 if(lastLoginTime!=0) {
			  msg="Success";
		 }
		 else
		 {
			  msg="Failure";
		 }
		return msg;
	}

	@Override
	public TblUsers addToFavourites(TblUsers requestData) {
		TblUsers user=new TblUsers();
		try {
			if(requestData!=null && requestData.getUserId()!=null) {
				user = usersRepository.findByUserIdAndStatus(requestData.getUserId(),ApplicationConstants.ACTIVE_STATUS);
				if(user!=null)
				{
				user.setFavourites(requestData.getFavourites());
				user= usersRepository.save(user);
				List<TblRoleMapping> rolesList=new ArrayList<>();
				user.setRolesList(rolesList);
				}
		return user;
			}	
	}catch(Exception e){
		e.printStackTrace();
	}
		return user;
}
}
