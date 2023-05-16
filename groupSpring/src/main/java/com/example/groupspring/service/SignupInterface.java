package com.example.groupspring.service;

import com.example.groupspring.model.Signup;


public interface SignupInterface {
    public Signup saveAccount(Signup signup);
    public Signup findAccount(String password);
    public boolean userCheck(String email, String password );
}
