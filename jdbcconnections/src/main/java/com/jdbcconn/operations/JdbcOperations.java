package com.jdbcconn.operations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class JdbcOperations {
	@Autowired
	JdbcTemplate jt;
	@Autowired
	NamedParameterJdbcTemplate ns;

	public int insert(Employee e) {
		int id = e.getEmpid();
		String fn = e.getFname();
		String ln = e.getLname();
		String des = e.getDesg();
		String ph = e.getPh();
		String em = e.getEmail();
		String us = e.getUsername();
		String pswd = e.getPassword();
		int addb = e.getAddby();

		String sql = "insert into Employee values(?,?,?,?,?,?,?,?,?)";
		int j = jt.update(sql, id, fn, ln, des, ph, em, us, pswd, addb);
		return j;
	}

	// NamedParameterJdbcTemplate
	public Map insert1(Employee e) {
		HashMap<String, String> hm = new HashMap<>();
		int id = e.getEmpid();
		String fn = e.getFname();
		String ln = e.getLname();
		String des = e.getDesg();
		String ph = e.getPh();
		String em = e.getEmail();
		String us = e.getUsername();
		String pswd = e.getPassword();
		int addb = e.getAddby();
		String sql = "insert into Employee(Empid,Empfirstname,Emplastname,Designation,phone_no,Email_id,password,addBy) values(:Id,:Fn,:Ln,:Des,:Ph,:Em,:Us,:Pswd,:Addb)";
		SqlParameterSource ps = new MapSqlParameterSource().addValue("Id", id).addValue("Fn", fn).addValue("Ln", ln)
				.addValue("Des", des).addValue("Ph", ph).addValue("Em", em).addValue("Us", us).addValue("Pswd", pswd)
				.addValue("Addb", addb);
		int i = ns.update(sql, ps);
		if (i > 0) {
			hm.put("success", "values inserted");
		} else {
			hm.put("failure", "values not inserted");
		}
		return hm;
	}

}
