package jdbcconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class EmployeeDatabaseCreation {
    public static String emailfunction(String f,String l) {
        f=f.toLowerCase();
    	return f.charAt(0)+l.toLowerCase()+"@intern.com";
    }
    public static String usernamefunction(String f,String l) {
    	f=f.toLowerCase();
    	return f.charAt(0)+l.toLowerCase();
    }
    public static String passwordfunction(String f,String l,String p){
    	return f.substring(0,2).toLowerCase()+l.substring(0,2).toLowerCase()+p.substring(9);
    }
    public static String rolefunction(Scanner sc) {
    	String r;
    	while(true) {
    		r=sc.nextLine().toLowerCase();
    		if(r.equals("hr") || r.equals("trainer") || r.equals("trainee")) {
    			break;
    		}
    		System.out.print("Enter the role again: ");
    	}
    	return r;
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
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		int id;
		String fname;
		String lname;
		String role;
		String phno;
		String email;
		String user_name;
		String pass;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Establishing the connection");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","M1racle@123");
		System.out.println("connection established");
		PreparedStatement ps=con.prepareStatement("insert into Employee(Empid,Empfirstname,Emplastname,Designation,phone_no,Email_id,user_name,password) values(?,?,?,?,?,?,?,?)");
		System.out.println("Enter no of rows to input");
		int no=sc.nextInt();
		for(int i=0;i<no;i++) {
			System.out.println("Enter the values");
			System.out.print("Enter the id:");
			id=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter your first name:");
			fname=sc.nextLine();
			System.out.print("Enter your last name:");
			lname=sc.nextLine();
			System.out.print("Enter your role:");
			role=rolefunction(sc);
			System.out.print("Enter your phone no:");
			phno=phonenumberfunction(sc);
//			System.out.println(phno.length());
			email=emailfunction(fname,lname);
			user_name=usernamefunction(fname,lname);
			pass=passwordfunction(fname,lname,phno);
			//now adding the values into the database
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, role);
			ps.setString(5, phno);
			ps.setString(6, email);
			ps.setString(7, user_name);
			ps.setString(8, pass);
			int j=ps.executeUpdate();
			if(j>0) {
				System.out.println("row has been inserted");
			}
			else {
				System.out.println("row was not inserted");
			}
		}
		con.close();
	}

}
