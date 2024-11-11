package com.springboot.ecom.controller;

import com.springboot.ecom.model.User;
import com.springboot.ecom.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users"; // Replace with the appropriate JSP view name
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "views/login"; // Refers to login.jsp in /WEB-INF/views/
    }

    @PostMapping("/users/login-form")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Perform login logic here - validate user, interact with database, etc.
        if (username.equals("correctUsername") && password.equals("correctPassword")) {
            model.addAttribute("msg", "Login successful");
            return "redirect:/home"; // Redirect to home or another page after successful login
        }
        model.addAttribute("msg", "Invalid username or password");
        return "views/login"; // Return back to login page on failure
    }
}
