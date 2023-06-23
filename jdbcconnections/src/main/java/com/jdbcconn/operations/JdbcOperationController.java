package com.jdbcconn.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class JdbcOperationController {
	@Autowired
	JdbcOperations j;

	@PostMapping("/emp-insert")
	public String insert(@RequestBody Employee e) {
		int i = j.insert(e);
		if (i > 0) {
			return "Data Inserted";
		} else {
			return "Data not Inserted";
		}
	}

	@PostMapping("/emp-insert1")
	public Map insert1(@RequestBody Employee e) {
		return j.insert1(e);
	}
}
