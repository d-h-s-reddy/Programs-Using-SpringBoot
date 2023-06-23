package com.example.userTable;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class usertablecontroller {
	@Autowired
	usertableservice us;

	@PostMapping("/insertUT")
	public Map insertUT(@RequestBody userTablePojo u) {
		System.out.println(u);
		HashMap<String, String> hm = new HashMap<>();
		int i = us.insertUT(u);
		if (i == 1) {
			hm.put("success", "data inserted");
		} else {
			hm.put("failure", "data not inserted");
		}
		return hm;
	}

	@PostMapping("/userLogin")
	public Map retrieve(@RequestBody userTablePojo u) {
		HashMap<String, String> hm = new HashMap<>();
		int i = us.retrieve(u);
		if (i == 1) {
			hm.put("success", "valid user");
		} else {
			hm.put("failure", "invalid user");
		}
		return hm;
	}

	@PutMapping("/userUpdate")
	public Map userUpdate(@RequestBody userTablePojo u) {
		HashMap<String, String> hm = new HashMap<>();
		int i = us.userUpdate(u);
		if (i == 1) {
			hm.put("success", "user details updated");
		} else {
			hm.put("failure", "user details are not updated");
		}
		return hm;
	}

	@DeleteMapping("/deleteuser")
	public Map userDelete(@RequestBody userTablePojo u) {
		HashMap hm = new HashMap<>();
		int i = us.deleteuser(u);
		if (i == 1) {
			hm.put("success", "user deleted");
		} else {
			hm.put("failure", "user not deleted");
		}
		return hm;
	}
	
//	@GetMapping("/selectUser")
//	public List selectdate() {
//		return us.selectdata();
//	}
}
