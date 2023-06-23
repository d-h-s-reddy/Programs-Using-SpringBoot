package jdbcconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class GettingFnameLnameUsername {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the first name:");
	    String fname=sc.nextLine();
	    System.out.print("Enter the last name:");
	    String lname=sc.nextLine();
	    System.out.print("Enter the user name:");
	    String u_name=sc.nextLine();
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
        String s="select * from Employee where 1+1=2";
        if(fname!="" || fname!=null) {
           String s1=" and Empfirstname like '"+fname+"%'";
           s=s+s1;
        }
        if(lname!="" || lname!=null) {
            String s2=" and Emplastname like '"+lname+"%'";
            s=s+s2;
         }
        if(u_name!="" || u_name!=null) {
            String s3=" and user_name like '"+u_name+"%'";
            s=s+s3;
         }
        PreparedStatement ps=con.prepareStatement(s);
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        	System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			System.out.println();
        }
	}
}
