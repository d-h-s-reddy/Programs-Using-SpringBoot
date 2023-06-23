package jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Oper {
	static int userid;
	static String role;
	public static boolean validation(Connection c,Scanner sc,String usr,String pass) throws Exception{
		PreparedStatement ps=c.prepareStatement("select * from Employee");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(usr.equals(rs.getString("user_name")) && pass.equals(rs.getString("password"))) {
				userid=rs.getInt("Empid");
				role=rs.getString("Designation").toLowerCase();
				System.out.println(role);
				return true;
			}
		}
		return false;
	}
	
	public static void insertoperation(Connection con,Scanner sc) throws Exception {
		System.out.print("Enter the role to add:");
		String role=sc.nextLine().toLowerCase();
		if(role.equals("hr")){
			System.out.println("You cannot enter the hr");
			return;
		}
		else {
			int id;
			String fname;
			String lname;
			String phno;
			String email;
			String user_name;
			String pass;
			System.out.println("Enter the values");
			System.out.print("Enter the id:");
			id=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter your first name:");
			fname=sc.nextLine();
			System.out.print("Enter your last name:");
			lname=sc.nextLine();
			System.out.print("Enter your phone no:");
			phno=phonenumberfunction(sc);
			fname=fname.toLowerCase();
			lname=lname.toLowerCase();
			email=fname.charAt(0)+lname+"@intern.com";
			user_name=fname.charAt(0)+lname;
			pass=fname.substring(0,2)+lname.substring(0,2)+phno.substring(9);
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, role);
			ps.setString(5, phno);
			ps.setString(6, email);
			ps.setString(7, user_name);
			ps.setString(8, pass);
			ps.setInt(9, userid);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("row is inserted successfully");
			}
			else {
				System.out.println("row is not inserted");
			}
			
		}
		
	}
	
	public static String phonenumberfunction(Scanner sc) {
    	long ph,temp;
    	while(true) {
    		ph=sc.nextLong();
    		temp=ph;
    		int count=0;
    		while(temp>0) {
    			temp=temp/10;
    			count++;
    		}
    		
    		if(count==10) {
    			break;
    		}
    		System.out.print("Please enter the correct number:");
    	}
    	String str=ph+"";
    	return "+91 "+str;
    }
	
	public static void updateoperation(Connection c,Scanner sc) throws Exception{
		sc.nextLine();
		System.out.print("Enter the field to update:");
		String field=sc.nextLine();
		String value;
		if(field.equals("phone_no")) {
			value=phonenumberfunction(sc);
		}
		else {
			System.out.print("Enter the value");
			value=sc.nextLine();
		}
		PreparedStatement ps=c.prepareStatement("update Employee set "+field+"=? where Empid=?");
		ps.setString(1, value);
		ps.setInt(2, userid);
		int j=ps.executeUpdate();
		if(j>0) {
			System.out.println("row is updated");
		}
		else {
			System.out.println("row is not updated");
		}
	}
	public static void deleteoperation(Connection c,Scanner sc) throws Exception{
		System.out.println("Enter the user id to delete");
		int usr=sc.nextInt();
		PreparedStatement ps=c.prepareStatement("delete from Employee where Empid=?");
		ps.setInt(1, usr);
		int j=ps.executeUpdate();
		if(j>0) {
			System.out.println("row has been deleted");
		}
		else {
			System.out.println("row is not deleted");
		}
	}
	public static void viewdetails(Connection c,Scanner sc) throws Exception{
		   System.out.println("Enter the option:\n1)Self Details\n2)Under Hr");
		   int ch=sc.nextInt();
		   String query;
		   if(ch==1) {
			   query="select * from Employee where Empid='"+userid+"'";
		   }
		   else {
			   query="select * from Employee where addBy='"+userid+"'";
		   }
		   PreparedStatement ps=c.prepareStatement(query);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			   System.out.println();
		   }
	}
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");	
		System.out.print("Enter the user name:");
		String usr=sc.nextLine();
		System.out.print("Enter the password:");
		String pwd=sc.nextLine();
		if(validation(con,sc,usr,pwd)) {
		if(role.equals("hr")) {
			while(true) {
				System.out.println("Enter the choice to perform operation:\n1)Insert\n2)Delete\n3)Update\n4)View\n5)exit");
				int choice=sc.nextInt();
				sc.nextLine();
				boolean flag=false;
				switch(choice) {
				   case 1:{
					    insertoperation(con,sc);
					    break;
				   }
				   case 2:{
					   updateoperation(con,sc);
					   break;
				   }
				   case 3:{
					   deleteoperation(con,sc);
					   break;
				   }
				   case 4:{
					   viewdetails(con,sc);
					   break;
				   }
				   case 5:{
					   System.exit(0);
				   }
				}
			}
		}
		else {
				System.out.println("Enter the operation:\n1)update\n2)exit");
				int choice=sc.nextInt();
				if(choice==1) {
					updateoperation(con,sc);
				}
				else {
					System.exit(0);
				}
		  }
		}
		else {
			System.out.println("Invalid user");
		}
		
		
		
//		rthamada
//		rath36777
	}

}
