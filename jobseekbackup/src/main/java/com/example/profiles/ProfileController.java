package com.example.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@CrossOrigin(origins = "*")
public class ProfileController {
	@Autowired
	ProfileService ps;
    @PostMapping("/insertp")
    public Map insertp(@RequestBody profilepojo p) {
    	HashMap<String,String> hm=new HashMap<>();
    	int i=ps.insertp(p);
    	if(i==1) {
    		hm.put("success", "profile data is added");
    	}
    	else {
    		hm.put("failure", "profile data is not added");
    	}
    	return hm;
    }
    @PutMapping("/updatep")
    public Map UpdateData(@RequestBody profilepojo p) {
    	HashMap<String,String> hm=new HashMap<>();
    	int i=ps.UpdateData(p);
    	if(i==1) {
    		hm.put("success", "profile data is added");
    	}
    	else {
    		hm.put("failure", "profile data is not added");
    	}
    	return hm;
    }
}
