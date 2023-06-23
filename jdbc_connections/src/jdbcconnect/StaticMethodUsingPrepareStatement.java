package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StaticMethodUsingPrepareStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("insert into student values(14,'hari',21)");
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("row has been inserted");
		}
		else {
			System.out.println("row has not inserted");
		}

	}

}
