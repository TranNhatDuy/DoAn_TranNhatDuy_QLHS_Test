package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.UserDTO;
import UTILS.*;


public class UserDAL {
	getConnection getcon = null;
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	/*public int inserUser(UserDTO userDTO) {
		//thực hiện kết nối cơ sở dữ liệu
		con = dbUtils.getMyConnection();
		//thực hiện insert dữ liệu vào bảng user
		int resultSet = 0;
		preparedStatement = con.prepareStatement(insert UserDTO(userName, password) values(?,?));
		return 0;
		
	}*/
	public ResultSet GetUserByNameNPass(UserDTO userDTO) throws ClassNotFoundException{
		
		String sql = "SELECT * FROM user WHERE userName=? AND password=?";
		try {
			getcon = new getConnection();
			con = getcon.getConnectionSQL();
			
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUserName());
			preparedStatement.setString(2, userDTO.getPassword());
			
			resultSet = preparedStatement.executeQuery();
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
		return resultSet;
		
	}
	
	
}
	