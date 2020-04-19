package BLL;
import java.sql.ResultSet;

import DAL.UserDAL;
import DTO.UserDTO;
public class UserBLL {
	UserDAL userDAL;
	public ResultSet LoGin(UserDTO userDTO) throws ClassNotFoundException {
		ResultSet result = null;
		if(userDTO.getUserName().equals(""))
			return result;
		else 
			if(userDTO.getPassword().equals(""))
				return result;
			else {
				UserDAL userDAL = new UserDAL();
				 result = userDAL.GetUserByNameNPass(userDTO);
			}
		
		return result;
	}
}
