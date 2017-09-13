package jdbc_connection;

import java.sql.*;
import org.junit.*;

/**@Method	TestConnection
 * test whether connection has been established
 * and query is executed
 **/
public class TestConnection {
	JDBCConnection connection = JDBCConnection.getConnection();
	
	/*@Method	testEstablishedConnection()
	 * test that a connection has been established
	 */
	@Test
	public void testEstablishedConnection(){
		Assert.assertNotNull( connection.getDBConnection() );
	}
	
	/*@Method	testGetNullQuery()
	 * execute query when query = null
	 */
	@Test(expected = SQLException.class)
	public void testGetNullQuery() throws SQLException{
		Assert.assertEquals(null, (ResultSet)connection.getData(null));
	}
	
	/*@Method	testExecuteEmptyQuery()
	 * execute query when query = ""
	 */
	@Test(expected = SQLException.class)
	public void testExecuteEmptyQuery() throws SQLException{
		Assert.assertEquals(null, (ResultSet)connection.getData(""));
	}
	
	/*@Method	testRetrieveQuery()
	 * execute query onto DB and return ResultSet table
	 */
	@Test
	public void testRetrieveQuery() throws SQLException{
		String query   = "SELECT member_name FROM members";
		
		Connection con = connection.getDBConnection();
		Statement stmt = con.createStatement();
		ResultSet expected = stmt.executeQuery(query);
		ResultSet actual   = connection.getData(query);

		while( expected.next() ){
			Assert.assertTrue( actual.next() );
			Assert.assertEquals( expected.getString("member_name"), actual.getString("member_name") );
		}
	}
}

