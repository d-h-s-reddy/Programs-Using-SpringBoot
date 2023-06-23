package com.example.jobtable;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class jobTableController {
	@Autowired
	jobTableService es;
	@PostMapping("/empdetails_insert")
	public Map insert(@RequestBody jobTable e) {
		return es.insertJob(e);
	}

	@GetMapping("/jobfetch")
	public List data() {
		return es.jobdata();
	}

}
