package com.major.kisaan.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.major.kisaan.user.User;

@Repository
public class UserDao {
	
	 private final JdbcTemplate jdbcTemplate;

	    public UserDao(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    public void save(User user) {
	        String sql = "INSERT INTO users (name, phoneNumber, password) VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, user.getName(), user.getPhoneNumber(), user.getPassword());
	    }

	    @SuppressWarnings("deprecation")
		public User findByPhoneNumber(String phoneNumber) {
	        String sql = "SELECT * FROM users WHERE phoneNumber = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{phoneNumber}, (rs, rowNum) -> {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            user.setPhoneNumber(rs.getString("phoneNumber"));
	            user.setPassword(rs.getString("password"));
	            return user;
	        });
	    }

}
