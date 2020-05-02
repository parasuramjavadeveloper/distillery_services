/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.hpfs.distillery.retailer.model.TblUsers;

/**
 * @author babasaheb
 *
 */
public interface UsersRepository extends JpaRepository<TblUsers,Long> {
	
	TblUsers findByUserNameAndStatus(String userName, String status);
	TblUsers findByUserNameAndPasswordAndStatus(String userName,String password,String status);
	TblUsers findByEmailId(String emailId);
	TblUsers findByMobileNumber(Long mobileNumber);
	TblUsers findByMobileNumberAndStatus(Long mobileNumber,String status);
	TblUsers findByUserIdAndMobileNumber(Long userId,Long mobileNumber);
	TblUsers findByUserIdAndEmailId(Long userId,String emailId);
	TblUsers findByUserIdAndPassword(Long userId,String pwd);
	TblUsers findByUserId(Long userId);
	TblUsers findByUserIdAndStatus(Long userId,String status);
	
	@Modifying
	@Query(value="UPDATE "+SCHEMA+"users SET password=?1 where user_id=?2",nativeQuery=true)
	int updateByUserId(String password,Long userId);
	
	TblUsers findByUserIdAndOtpAndStatus(Long userId,Long otp,String status);
	
	List<TblUsers> findAllByStatus(String activeStatus);
	
	@Modifying
	@Query(value="UPDATE "+SCHEMA+"users SET last_login_time=CURRENT_TIMESTAMP() WHERE user_id=?1",nativeQuery=true)
	int sp_last_login(Long userId);

}
