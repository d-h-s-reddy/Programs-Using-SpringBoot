package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.*;
public class UpdateUsingPrepareStatement {

	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is loaded");
		System.out.println("Enter the values:");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int id=sc.nextInt();
		int age=sc.nextInt();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("update student set age=? where name=? and id=?");
		ps.setInt(3, id);
		ps.setString(2, name);
		ps.setInt(1, age);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("row has been effected");
		}
		else {
			System.out.println("row has not effected");
		}

	}

}
