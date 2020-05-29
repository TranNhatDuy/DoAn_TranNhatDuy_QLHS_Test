package BLL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAL.UserDAL;
import DTO.UserDTO;
import DTO.UserDTO;
public class UserBLL {
	UserDAL userDAL = new UserDAL();
	public ResultSet LoGin(UserDTO userDTO) throws SQLException {
		ResultSet resultSet = null;
		try {
			resultSet = userDAL.GetUserByNameNPass(userDTO);
			if(resultSet.next()) {
				return resultSet;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
	}
//	public ArrayList<UserDTO> getUsersById() throws ClassNotFoundException {
//	 return userDAL.getUsersById(null);
//	}
}
