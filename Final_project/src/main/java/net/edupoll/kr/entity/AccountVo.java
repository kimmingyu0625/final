package net.edupoll.kr.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class AccountVo {
	@Size(min = 4, max = 8,message = "아이디는 4~8자 사이로 입력바랍니다.")
	String userId;
	
	String userPass;
	@Pattern(regexp = "[가-힇]{2,5}",message = "이름은 한글로 2~5자 사이만 입력가능합니다.")
	String userName;
	
	@javax.validation.constraints.Email
	String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	String zipcode;
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	String address;
	String auth;
	String profile;
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "AccountVo [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
