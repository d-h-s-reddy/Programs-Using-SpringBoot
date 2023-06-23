package jdbcconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class InsertUsingPrepareStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is loaded");
		System.out.println("Enter the values:");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int id=sc.nextInt();
		int age=sc.nextInt();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("row has been inserted");
		}
		else {
			System.out.println("row has not inserted");
		}
	}
}
