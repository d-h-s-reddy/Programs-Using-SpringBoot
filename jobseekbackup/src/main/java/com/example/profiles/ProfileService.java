package com.example.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProfileService {
	@Autowired
	NamedParameterJdbcTemplate jt;
	@Autowired
	JdbcTemplate j;

	public int insertp(profilepojo p) {
		String firstname = p.getFirstName();
		String lastname = p.getLastName();
		long phoneno = p.getPhoneNo();
		int yearOfPassing = p.getYearOfPassing();
		byte[] img = p.getImage();
		String experience = p.getExperiences();
		System.out.println(experience);
		String gender = p.getGender();
		String address = p.getAddress();
		String email = p.getEmail();
		String sql = "insert into Profile(First_Name,Last_Name,Phone_no,Year_Of_Passing,Image,Gender,Address,Email,Experience) values(:fn,:ln,:ph,:yearofpass,:img,:gender,:add,:em,:exp)";
		SqlParameterSource ps = new MapSqlParameterSource().addValue("fn", firstname).addValue("ln", lastname)
				.addValue("ph", phoneno).addValue("yearofpass", yearOfPassing).addValue("img", img)
				.addValue("exp", experience).addValue("gender", gender).addValue("add", address).addValue("em", email);
		return jt.update(sql, ps);
	}

	public int UpdateData(profilepojo p) {
		String fieldname;
		long valuel;
		int valuei;
		String value;
		String adding = "update Profile set ";
		if (p.getFirstName() != null) {
			fieldname = "First_Name";
			value = p.getFirstName();
			adding += fieldname + "='" + value + "',";
		}
		if (p.getLastName() != null) {
			fieldname = "Last_Name";
			value = p.getLastName();
			adding += fieldname + "='" + value + "',";
		}
		if (p.getPhoneNo() != 0) {
			fieldname = "Phone_no";
			valuel = p.getPhoneNo();
			adding += fieldname + "=" + valuel + ",";
		}
		if (p.getYearOfPassing() != 0) {
			fieldname = "Year_of_Passing";
			valuei = p.getYearOfPassing();
			adding += fieldname + "=" + valuei + ",";
		}
		if (p.getExperiences() != null) {
			fieldname = "Experience";
			value = p.getExperiences();
			adding += fieldname + "=" + value + ",";
		}
		if (p.getGender() != null) {
			fieldname = "Gender";
			value = p.getGender();
			adding += fieldname + "='" + value + "',";
		}
		if (p.getAddress() != null) {
			fieldname = "Address";
			value = p.getAddress();
			adding += fieldname + "='" + value + "',";
		}
		int length = adding.length();
		adding = adding.substring(0, length - 1);
		String em = p.getEmail();
		adding += " where Email=?";
		return j.update(adding, em);
	}
}
