package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class userverficationcontroller {
  @Autowired
  userverificationsrvice vs;
  
  //taking the data for verfication
  @PostMapping("/signinverfication/{val}")
  public String userveri(@PathVariable String val) {
	  System.out.println(val);
	  return vs.userveri(val);
  }
}
