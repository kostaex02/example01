package watermelon.dto;

public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userGender;
	private String userCheck;
	
	public User(){}

	public User(String userId, String userPassword, String userName, String userBirth, String userGender,
			String userCheck) {
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

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserCheck() {
		return userCheck;
	}

	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}
	
}
