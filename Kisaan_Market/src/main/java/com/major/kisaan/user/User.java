package com.major.kisaan.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {
	private int id;
    private String name;
    private String phoneNumber;
    private String password;

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String string) { this.phoneNumber = string; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
	
}
