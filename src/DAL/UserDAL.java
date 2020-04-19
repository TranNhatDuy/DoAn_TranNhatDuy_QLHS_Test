package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.UserDTO;
import UTILS.ConnectionUtils;


public class UserDAL {
	ConnectionUtils dbUtils;
	Connection con;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/*public int inserUser(UserDTO userDTO) {
		//thực hiện kết nối cơ sở dữ liệu
		con = dbUtils.getMyConnection();
		//thực hiện insert dữ liệu vào bảng user
		int resultSet = 0;
		preparedStatement = con.prepareStatement(insert UserDTO(userName, password) values(?,?));
		return 0;
		
	}*/
	public ResultSet GetUserByNameNPass(UserDTO userDTO) throws ClassNotFoundException{
		ResultSet result = null;
		String sql = "Select * from user where username = ? and password = ?";
		try {
			dbUtils =  new ConnectionUtils();
			con = dbUtils.getMyConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			try {
				con.close();
				preparedStatement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
}
	