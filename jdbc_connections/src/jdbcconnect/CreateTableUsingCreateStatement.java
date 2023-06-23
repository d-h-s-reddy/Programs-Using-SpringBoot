package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableUsingCreateStatement {

	public static void main(String[] args){
		try {
			//1)loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2)establishing the connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
			System.out.println("connection established");
			//3) creating the statement
			Statement s=c.createStatement();
			//4) executing the query
			if(s.execute("create table student(id int,name varchar(20),age int)")) {
				System.out.println("table created");
			}
			else {
				System.out.println("table is not created");
			}
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
