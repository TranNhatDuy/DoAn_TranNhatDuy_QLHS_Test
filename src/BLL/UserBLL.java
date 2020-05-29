package BLL;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.UserDAL;
import DTO.UserDTO;
import DTO.UserDTO;
public class UserBLL {
	UserDAL userDAL;
	public ResultSet LoGin(UserDTO userDTO) {
		ResultSet resultSet = null;
		try {
			resultSet = userDAL.GetUserByNameNPass(userDTO);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	public ArrayList<UserDTO> getUsersById() throws ClassNotFoundException {
	 return userDAL.getUsersById(null);
	}
}
