package jdbcconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ExtactingData {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the details:");
		System.out.print("Enter the firstName:");
		String fname=sc.nextLine();
		System.out.print("Enter the lastName:");
		String lname=sc.nextLine();
		System.out.print("Enter the userName:");
		String user_name=sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("select * from Employee where Empfirstname like '"+fname+"%' and Emplastname like '"+lname+"%' and user_name like '"+user_name+"%'");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			System.out.println();
		}

	}
}
