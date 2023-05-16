package com.example.groupspring.repository;

import com.example.groupspring.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository <Signup,String>{
}
