package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**@Class	JDBCConnection
 * establish connection with the MySQL database
 * using client-side server adapter
 **/
public class JDBCConnection {
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "library_information_system";
	
	private static final String userId = "root";
	private static final String password = "cbu";
	
	Connection con = null;
	
	private static JDBCConnection db_connection = null;
	private JDBCConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host+dbName, userId, password);	
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*@Method	getConnection()
	 * get helper connection object 
	 * 1 object to access all DB query for 1 DB
	 */
	public static JDBCConnection getConnection(){
		if(db_connection == null ){
			synchronized(JDBCConnection.class) {
				if(db_connection == null) {
					return db_connection = new JDBCConnection();
				}
			}
		}
		return db_connection;
	}
	
	/*@Method	getDBConnection()
	 * get DB connection object
	 */
	public Connection getDBConnection(){
		return con;
	}
	
	/*@Method	getData(String query)
	 * execute sql query by accessing the DB
	 *@return	ResultSet, virtual table for requested query
	 */
	public ResultSet getData(String query) throws SQLException {
		Statement statement = con.createStatement();
		return statement.executeQuery(query);
	}
	
	/*@Method	setData(String query)
	 * set data entry onto DB
	 * @return	success/failure of execute query operation
	 */
	public boolean setData(String query) throws SQLException {
		Statement statement = con.createStatement();
		return statement.executeUpdate(query) > 0;
	}
}