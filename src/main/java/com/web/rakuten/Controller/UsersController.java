package com.web.rakuten.Controller;

import com.web.rakuten.Model.Users;
import com.web.rakuten.Service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RestController
@RequestMapping("/user")
public class UsersController {
    
    public final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value="/register")
    public String postMethodName(@RequestBody Users user) {
        
        usersService.registerUser(user);

        return "Successful1!!!";
    }
    
}
