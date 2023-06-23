package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ExtractingDataUsingEqual {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		String fname;
		String lname;
		String username;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		System.out.println("1)Firstname\n2)Lastname\n3)Username\n4)Firstname and Lastname\n5)Firstname and username\n6)Lastname and username\n7)Firstname, Lastname and username");
		int choice=sc.nextInt();
		sc.nextLine();
		String query="";
		switch(choice) {
		case 1: 
			System.out.print("Enter the firstName:");
			fname=sc.nextLine();
			query="select * from Employee where Empfirstname='"+fname+"'";
			System.out.println(query);
			break;
		case 2:{
			System.out.print("Enter the lastName:");
			lname=sc.nextLine();
			query="select * from Employee where Emplastname='"+lname+"'";
			break;
		}
		case 3:{
			System.out.print("Enter the userName:");
			username=sc.nextLine();
			query="select * from Employee where user_name='"+username+"'";
			break;
		}
		case 4:{
			System.out.print("Enter the firstName:");
			fname=sc.nextLine();
			System.out.print("Enter the lastName:");
			lname=sc.nextLine();
			query="select * from Employee where Empfirstname='"+fname+"' and Emplastname='"+lname+"'";
	        break;	
		}
		case 5:{
			System.out.print("Enter the firstName:");
			fname=sc.nextLine();
			System.out.print("Enter the userName:");
			username=sc.nextLine();
			query="select * from Employee where Empfirstname='"+fname+"' and user_name='"+username+"'";
		    break; 
		}
		case 6:{
			System.out.print("Enter the lastName:");
			lname=sc.nextLine();
			System.out.print("Enter the userName:");
			username=sc.nextLine();
			query="select * from Employee where Emplastname='"+lname+"' and user_name='"+username+"'";
            break;		
		}
		case 7:{
			System.out.print("Enter the firstName:");
			fname=sc.nextLine();
			System.out.print("Enter the lastName:");
			lname=sc.nextLine();
			System.out.print("Enter the userName:");
			username=sc.nextLine();
			query="select * from Employee where Emplastname='"+lname+"' and user_name='"+username+"' and Empfirstname='"+fname+"'";
		    break;
		}
	}
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			System.out.println();

		}
		
	}
}
