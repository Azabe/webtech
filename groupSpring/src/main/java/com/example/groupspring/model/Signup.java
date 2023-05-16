package com.example.groupspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Signup {
	
  @Id
  @NotBlank(message = "Password is required")
  @Size(min = 6, message = "Password must be at least 6 characters long")
  protected String password;
  @Email(message = "Invalid email format")
  @NotBlank(message = "Email is required")
    protected String email;
  
  
    public Signup() {
    }

    public Signup(String password) {
        this.password = password;
    }

    public Signup(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	
    
}
