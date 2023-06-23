package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
@Service
public class userverificationsrvice {
	@Autowired
	jobseekerRepository jr;
  public String userveri(String val) {
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
    	  return "please enter the correct eamil or phone number";
      }
  }
  public String validate(String name,int flag) {
	     System.out.println("welcome");
		   ArrayList<userverification> ls=new ArrayList<>();
		   ls=(ArrayList<userverification>) jr.findAll();
		   System.out.println(ls);
		   Iterator l=ls.iterator();
		   boolean flagtf=false;
		   while(l.hasNext()) {
			   userverification r1=(userverification) l.next();
			   System.out.println(r1.getEmail());
			   if(flag==0) {
				   System.out.println(r1.getEmail());
				   if(name.equals(r1.getEmail())) {
					   System.out.println("checking ");
					   flagtf=true;
					   break;
				   }
			   }
			   else {
				   if(name.equals(r1.getPh())) {
					   flagtf=true;
				  }
			  }
		   }
		 if(flagtf==true) {
			 return "valid user";
		 }
		 else {
			 return "not a valid user";
		 }
	   }
  
  public List<userverification> read() {
	  return jr.findAll();
  }
}
