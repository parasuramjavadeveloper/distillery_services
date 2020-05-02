package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.RolePermissionsDto;
import com.hpfs.distillery.retailer.dto.UserChangePwd;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.dto.UserRolesDto;
import com.hpfs.distillery.retailer.model.TblPermissions;
import com.hpfs.distillery.retailer.model.TblRoles;
import com.hpfs.distillery.retailer.model.TblUserPermissions;
import com.hpfs.distillery.retailer.model.TblUsers;
import com.hpfs.distillery.retailer.service.UserService;

import io.swagger.annotations.Api;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/user")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveOrUpdateUserRolesMap")
	public Response<String> saveOrUpdateUserRolesMap(@RequestBody Request<UserRolesDto> request) {
		String responseData = userService.saveOrUpdateUserRolesMap(request.getRequestData());
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveRolePermissions")
	public Response<String> saveRolePermissions(@RequestBody Request<RolePermissionsDto> request) {
		String responseData = userService.saveRolePermissions(request.getRequestData());
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/addToFavourites")
	public Response<TblUsers> addToFavourites(@RequestBody Request<TblUsers> request) {
		TblUsers responseData = userService.addToFavourites(request.getRequestData());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchUserRolePermByUserId")
	public Response<UserRolesDto> fetchUserRolePermByUserId(@RequestBody Request<TblUsers> request) {
		UserRolesDto responseData = userService.fetchUserRolePermByUserId(request.getRequestData());
		return new Response<UserRolesDto>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/userExists")
	public String isUserExists(@RequestParam String userName) {
		Long isUserExists = userService.isUserExists(userName);
		logger.info("@@@@--" + isUserExists);
		if (isUserExists > 0) {
			return new String("Already User Name Exists");
		} else {
			return new String("No User Exists in DB with this Name");
		}

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/login")
	public Response<UserRolesDto> userLogin(@RequestBody Request<UserRolesDto> request) {
		UserRolesDto responseData = userService.login(request.getRequestData().getUserName(),
				request.getRequestData().getPassword());
		return new Response<UserRolesDto>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/mlogin")
	public Response<TblUsers> userMLogin(@RequestBody Request<TblUsers> request) {
		TblUsers responseData = userService.userMlogin(request.getRequestData().getUserName(),
				request.getRequestData().getPassword());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/loginWithMobile")
	public Response<TblUsers> loginWithMobile(@RequestBody Request<TblUsers> request) {
		TblUsers responseData = userService.loginWithMobile(request.getRequestData());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/userOTPLogin")
	public Response<List<TblUserPermissions>> userOTPLogin(@RequestBody Request<TblUsers> request) {
		List<TblUserPermissions> responseData = userService.userOTPLogin(request.getRequestData());
		return new Response<List<TblUserPermissions>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateUserDts")
	public Response<TblUsers> updateUserDts(@RequestBody Request<TblUsers> request) {
		TblUsers responseData = userService.updateUserDts(request.getRequestData());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/validateEmailNum")
	public Response<TblUsers> validateEmailNum(@RequestBody Request<UserDetails> request) {
		TblUsers responseData = userService.validateEmailNum(request.getRequestData().getEmailOrNum());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/generateOTP")
	public Response<TblUsers> generateOTP(@RequestBody Request<UserDetails> request) {
		TblUsers responseData = userService.generateOTP(request.getRequestData().getUserId(),
				request.getRequestData().getEmailOrNum());
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/createNewPwd")
	public Response<String> createNewPwd(@RequestBody Request<UserChangePwd> request) {
		String msg = userService.createNewPwd(request.getRequestData());
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), msg);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/changePwd")
	public Response<String> changePwd(@RequestBody Request<UserChangePwd> request) {
		String msg = userService.changePwd(request.getRequestData());
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), msg);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActiveRoles")
	public Response<List<TblRoles>> fetchActiveRoles() {
		List<TblRoles> rolesList = userService.fetchActiveRoles();
		return new Response<List<TblRoles>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), rolesList);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActiveUsers")
	public Response<List<TblUsers>> fetchActiveUsers() {
		List<TblUsers> usersList = userService.fetchActiveUsers();
		return new Response<List<TblUsers>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), usersList);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchPermissionsByRoleId")
	public Response<List<TblPermissions>> fetchPermissionByRoleId(@RequestBody Request<TblPermissions> request) {
		List<TblPermissions> perList = userService.fetchPermissionByRoleId(request.getRequestData().getRoleId());
		return new Response<List<TblPermissions>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), perList);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchAllPermissionsDts")
	public Response<List<TblPermissions>> fetchAllPermissionsDts() {
		List<TblPermissions> perList = userService.fetchAllPermissionsDts();
		return new Response<List<TblPermissions>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), perList);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/spLastLogin")
	public Response<TblUsers> spLastLogin(@RequestBody Request<TblUsers> request) {
		TblUsers users = userService.spLastLogin(null != request ? request.getRequestData() : null);
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), users);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/spLastLoginForWeb")
	public Response<String> spLastLoginWeb(@RequestBody Request<TblUsers> request) {
		String  msg = userService.spLastLoginForWeb(null != request ? request.getRequestData() : null);
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),msg);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchByUserId")
	public Response<TblUsers> fetchUserDtsByUserId(@RequestBody Request<TblUsers> request) {
		TblUsers users = userService.fetchUserDtsByUserId(null != request ? request.getRequestData() : null);
		return new Response<TblUsers>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), users);

	}

	private PageInfo getPageInfo(@RequestBody(required = false) Request request) {
		PageInfo pageInfo = new PageInfo();
		if (request != null && request.getPageInfo() != null) {
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}

}