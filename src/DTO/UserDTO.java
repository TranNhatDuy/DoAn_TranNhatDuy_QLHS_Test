package DTO;

public class UserDTO {
	private String userName, password, role, UserID;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDTO(String UserName, String Password) {
		// TODO Auto-generated constructor stub
		this.userName = UserName;
		this.password = Password;
	}
	public UserDTO(){
		userName = "";
		password = "";
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

}
