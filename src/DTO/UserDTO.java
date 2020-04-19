package DTO;

public class UserDTO {
	private String userName, password;

	public UserDTO(String UserName, String Password) {
		// TODO Auto-generated constructor stub
		this.userName = UserName;
		this.password = Password;
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

	
	
}
