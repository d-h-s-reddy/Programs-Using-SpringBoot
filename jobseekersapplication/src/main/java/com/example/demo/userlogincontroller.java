package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userlogincontroller {
	@Autowired
	userloginservice us;
   @PostMapping("/userlogin/{val}")
   public List<userlogin> searching(@PathVariable String val) {
	   return us.searching(val);
   }
}
