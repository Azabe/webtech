package com.example.groupspring.controller;
import com.example.groupspring.model.Signup;
import com.example.groupspring.service.SignupInterface;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class SignupController {
    @Autowired
    SignupInterface signupInterface;

//     @RequestMapping(method = RequestMethod.GET)
//     @GetMapping("/login-page")
//     public String home(Model model){
//         Signup signup=new Signup();
//         model.addAttribute("login",signup);
//         return "login";
//     }

    @GetMapping("/")
    public String homepage(Model model){
        Signup signup=new Signup();
        model.addAttribute("login",signup);
       return "login";
    }
    
    @GetMapping("/login-page")
    public String login(Model model){
        Signup signup=new Signup();
        model.addAttribute("login",signup);
       return "login";
    }
    @GetMapping("/fail-page")
    public String loginfail(Model model){
        Signup signup=new Signup();
        model.addAttribute("login",signup);
       return "fail_log";
    }

    @GetMapping("/Signup")
    public String registration(Model model){
        Signup signup=new Signup();
        model.addAttribute("signup",signup);
        return "signup";
    }
@PostMapping("/registerAccount")
    public String saveAccount(@Valid @ModelAttribute("signup") Signup theSignup, BindingResult result ) {
	if (result.hasErrors()) {
        // Handle validation errors
        return "Signup";
    }
	signupInterface.saveAccount(theSignup);
	return "redirect:/login-page";
}

/*
 * Signup signup = signupInterface.saveAccount(theSignup); if (signup != null) {
 * return "redirect:/login-page"; } else { return "redirect:/Signup"; }
 */

    @PostMapping("/authentication")
    public String userAuthentication(@RequestParam String email,@RequestParam String password){
          signupInterface.userCheck(email,password);
        if (signupInterface.userCheck(email,password)){
        		return "index";
            
        }else {
            return "redirect:/fail-page";
        }
    }
}
