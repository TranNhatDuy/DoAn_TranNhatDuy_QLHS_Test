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
	getConnection getcon;
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
		String sql = "Select * from user where userName = ? and password = ?";
		try {
			getcon = new getConnection();
			con = getcon.getConnectionSQL();
			
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUserName());
			preparedStatement.setString(2, userDTO.getPassword());
			
			result = preparedStatement.executeQuery();
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
	
	//liệt kê danh sách toàn bộ nhân viên
	public ResultSet GetAllUser	() throws ClassNotFoundException{
		UserDTO userDTO = new UserDTO();
		ResultSet result_ListUser = null;
		String sql = "Select * from test.user";
		try {
			getcon = new getConnection();
			con = getcon.getConnectionSQL();
			
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUserName());
			preparedStatement.setString(2, userDTO.getPassword());
			
			result_ListUser = preparedStatement.executeQuery();
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
		return result_ListUser;
	
	}
	public ResultSet INFOUser (UserDTO userDTO) throws ClassNotFoundException{
		ResultSet result = null;
		String sql = "select * from test.user where userName=? AND password=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionUtils dbUtils = new ConnectionUtils();
			con = dbUtils.getMyConnection();
			
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUserName());
			preparedStatement.setString(2, userDTO.getPassword());
			
			result = preparedStatement.executeQuery();
			if(result.next()) {
				String sqlGetInfo = "select * form test.infomation where UserID=?";
				try {
					ConnectionUtils dbUtils1 = new ConnectionUtils();
					con = dbUtils1.getMyConnection();
					
					preparedStatement=con.prepareStatement(sqlGetInfo);
					preparedStatement.setString(1, result.getString("UserID"));

					result = preparedStatement.executeQuery();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
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

	public ArrayList<UserDTO> getUsersById(UserDTO userDTO) throws ClassNotFoundException{

        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
		ArrayList<UserDTO> result = new ArrayList<UserDTO>();
		String sqlSelectById = "select * from user where UserID = ?";
        
		try {
			getcon = new getConnection();
			con = getcon.getConnectionSQL();
			preparedStatement = con.prepareStatement(sqlSelectById);
			preparedStatement.setString(1, userDTO.getUserID());        
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UserDTO user = new UserDTO();
				userDTO.setUserID(resultSet.getString("UserID"));
				userDTO.setUserName(resultSet.getString("userName"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setRole(resultSet.getString("role"));
				result.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
	