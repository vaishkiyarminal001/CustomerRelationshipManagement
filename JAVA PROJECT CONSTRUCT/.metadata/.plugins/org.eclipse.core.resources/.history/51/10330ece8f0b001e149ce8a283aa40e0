package com.masai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AdminCreds")

public class AdminCreds {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(name = "username", unique = true, nullable = false)
	    private String username;
	    
	    @Column(name = "password", nullable = false)
	    private String password;
	    
	    public AdminCreds() {
	    }

	    public AdminCreds(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    // Getters and setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

}
