package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeetableOPerations {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		System.out.println("1)Create table\n2)Insert the table\n3)Update the table4)Delete the table");
		

	}

}
