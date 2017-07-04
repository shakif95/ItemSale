import java.sql.*;
public class DBConnect {
	 Connection conn = null;
	 Statement st;
	 ResultSet rs;
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/itemsale";
	 
	 static final String username = "root";
	 static final String pass = "";
	 
	 public static DBConnect instance = null;
	 
	 public DBConnect(){
		 try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,username,pass);
			
			if(conn==null){
				System.out.println("Connection fail");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Connection successfull");
	 }
	 
	 public synchronized static DBConnect getInstance(){
		 if(instance==null){
			 instance = new DBConnect();
		 }
		 return instance;
	 }
	 
	 public ResultSet getProducts(String query){
		 try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return rs;
	 }
	 
}
