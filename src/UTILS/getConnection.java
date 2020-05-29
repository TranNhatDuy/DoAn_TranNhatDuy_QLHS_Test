package UTILS;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
 
 private String db_url = null;
 private String db_user = null;
 private String db_password = null;
 private String db_driver = null;
 private String db_name = null;
 private Connection con;
 
 	public Connection getConnectionSQL() throws SQLException,
	ClassNotFoundException{
	
 		try {
		 
//		 db_url = "jdbc:mysql://localhost:3306;databaseNames=test";
			 db_user = "root";
			 db_password = "";
			 db_driver = "Driver";
			 db_name = "test";
			 String Url = "jdbc:mysql://" + db_user + ":3306/" + db_name;
//			 Class.forName(db_driver);
			 Class.forName("com.mysql.jdbc.Driver");
			 System.err.println("Hello");
			 con = DriverManager.getConnection(Url, db_user, db_password);
		
		 } catch (ClassNotFoundException e) {
			 System.err.println("Không tìm thấy class.");
		 } catch (SQLException e) {
			 System.err.println("Lỗi kết nối cơ sở dư liệu.");
			 System.out.println(con);
		 }
		 if (con == null) {
			 throw new NullPointerException("Kết nối không thành công.");
		 }
		 return con;
 	}
} 