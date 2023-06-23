package com.example.userTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class usertableservice {
	
	@Autowired
	NamedParameterJdbcTemplate jt;
	@Autowired
	JdbcTemplate j;
   public int insertUT(userTablePojo u) {
	   String userNa=u.getUserName();
	   String password=u.getPassword();
	   String email=u.getEmail();
	   String role=u.getRole();
	   String sql="insert into usertable(user_name,password,email,role) values(:un,:pwd,:em,:role)";
	   SqlParameterSource ps=new MapSqlParameterSource()
			   .addValue("un", userNa)
			   .addValue("pwd", password)
			   .addValue("em", email)
			   .addValue("role", role);
	   int i=jt.update(sql, ps);
	   return i;
   }
   
   public int retrieve(userTablePojo u) {
	   String email=u.getEmail();
	   String password=u.getPassword();
	   String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	   Pattern emailPattern = Pattern.compile(emailRegex);
       Matcher emailMatcher = emailPattern.matcher(email);
       if(emailMatcher.matches()) {
    	   return validate(email,password,0);
       }
       else {
    	   return 0;
       }
   }
   public int validate(String val,String password,int flag) {
  	    String sql="select count(*) from usertable where 1+1=2 ";
  	    if(flag==0) {
  	    	sql+="and email='"+val+"' and password='"+password+"'";
  	    }
  	    else {
  	    	sql+="and userName='"+val+"' and password='"+password+"'";
  	    }
  	    return j.queryForObject(sql, Integer.class);
   }
   
   public int userUpdate(userTablePojo u) {
	   String value;
	   String fieldname;
	   String sql="update usertable set ";
	   String email=u.getEmail();
	   if(u.getUserName()!=null) {
		   fieldname="user_name";
		   value=u.getUserName();
		   sql+=fieldname+"= '"+value+"',";
	   }
	   if(u.getPassword()!=null) {
		   fieldname="password";
		   value=u.getPassword();
		   sql+=fieldname+"= '"+value+"' ,";
	   }
	   int length=sql.length();
	   sql=sql.substring(0,length-1);
	   sql+=" where email=?";
	   System.out.println(sql);
	   return j.update(sql,email);
   }
   
   public int deleteuser(userTablePojo u) {
	   String email=u.getEmail();
	   String sql="delete from usertable where email=?";
	   return j.update(sql,email);
   }
   
//   public List selectdata() {
//	   
//   }
}
