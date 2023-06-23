package com.example.jobtable;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@Service
public class jobTableService {
	@Autowired
	JdbcTemplate js;
	
	@Autowired
	NamedParameterJdbcTemplate ns;
	public Map insertJob(jobTable e) {
	  HashMap<String,String>hm=new HashMap<>();
	  int id = e.getId();
	  String title=e.getTitle();
	  String jobType=e.getJobType();
	  int company_id=e.getCompany_id();
	  String location=e.getLocation();
		int salary = e.getSalary();
		String companyName = e.getCompanyName();
		String jobSkills = e.getJobSkills();
		LocalDateTime date_posted = LocalDateTime.now();
		String sql = "INSERT INTO Jobs (id, title, jobType, company_id, location, salary, date_posted,companyName,jobSkills) values(:id,:title,:jobType,:company_id,:location,:salary,:date_posted,:companyName,:jobSkills)";
		SqlParameterSource ps = new MapSqlParameterSource().addValue("id", id).addValue("title", title)
				.addValue("jobType", jobType).addValue("company_id", company_id).addValue("location", location)
				.addValue("salary", salary).addValue("date_posted", date_posted).addValue("companyName", companyName)
				.addValue("jobSkills", jobSkills);
		// LocalDateTime date_posted = LocalDateTime.now();
		int i = ns.update(sql, ps);
		if (i > 0) {
			hm.put("Successs", "values inserted");
		} else {
			hm.put("Failure", "values not inserted");
		}
		return hm;
	}

	public List jobdata() {
		List getData = new ArrayList();
		HashMap dataList = null;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		String sql = "select * from Jobs";
		data = js.queryForList(sql);
		for (Map listdata : data) {
			dataList = new HashMap();
			dataList.put("id", listdata.get("id"));
			dataList.put("title", listdata.get("title"));
			dataList.put("jobType", listdata.get("jobType"));
			dataList.put("company_id", listdata.get("company_id"));
			dataList.put("location", listdata.get("location"));
			dataList.put("salary", listdata.get("salary"));
			dataList.put("date_posted", listdata.get("date_posted"));
			dataList.put("companyName", listdata.get("companyName"));
			dataList.put("jobSkills", listdata.get("jobSkills"));
			getData.add(dataList);
		}
		return getData;
	}
		
	}
