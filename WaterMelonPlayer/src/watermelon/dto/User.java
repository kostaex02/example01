package watermelon.dto;

import java.util.Date;

public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private Date userBirth;
	private int userGender;
	private int userCheck;
	
	public User(){}

	public User(String userId, String userPassword, String userName, Date userBirth, int userGender,
			int userCheck) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userCheck = userCheck;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public int getUserCheck() {
		return userCheck;
	}

	public void setUserCheck(int userCheck) {
		this.userCheck = userCheck;
	}
	
}
