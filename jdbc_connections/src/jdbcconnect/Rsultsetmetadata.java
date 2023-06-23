package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Rsultsetmetadata {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("Select * from Employee");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rm=rs.getMetaData();
		System.out.println(rm.getColumnCount());
		//Printing the column names
		for(int i=1;i<=rm.getColumnCount();i++) {
			System.out.print(rm.getColumnName(i)+" ");
			System.out.print(rm.getColumnLabel(i)+" ");
		}
		con.close();
	}
}
