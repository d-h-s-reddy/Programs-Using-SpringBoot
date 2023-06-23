package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUsingPrepareStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is loaded");
		System.out.println("Enter the values:");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("row has been effected");
		}
		else {
			System.out.println("row has not effected");
		}
	}
}
