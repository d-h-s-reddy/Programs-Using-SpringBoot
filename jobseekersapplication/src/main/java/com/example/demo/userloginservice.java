package com.example.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class userloginservice {
    @Autowired
    JdbcTemplate js;
    public List searching(String val) {
    	String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[+]?[0-9]{10,13}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(val);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher = phonePattern.matcher(val);
        if(emailMatcher.matches()) {
      	  System.out.println("enterning");
      	  return validate(val,0);
        }
        else if(phoneMatcher.matches()){   
      	  return validate(val,1);
        }
        else {
        	return null;
        }
    }
    public List validate(String val,int flag) {
    	List getdata=new ArrayList<>();
   	    HashMap datalist=null;
   	    List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
   	    String sql="select * from registrations where 1+1=2 ";
   	    if(flag==0) {
   	    	sql+="and email=?";
   	    }
   	    else {
   	    	sql+="and ph=?";
   	    } 
   	    System.out.println(sql);
   	    data=js.queryForList(sql,val);
   	    for(Map newdata:data) {
		 datalist=new HashMap<>();
		 datalist.put("fname", newdata.get("fname"));
		 datalist.put("lname", newdata.get("lname"));
		 datalist.put("ph", newdata.get("ph"));
		 datalist.put("em", newdata.get("email"));
		 datalist.put("us", newdata.get("uname"));
		 datalist.put("pswd", newdata.get("pswd"));
		 getdata.add(datalist);
	  }
   	  return getdata;
   	   
    	
    }
}
