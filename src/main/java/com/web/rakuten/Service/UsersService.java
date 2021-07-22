package com.web.rakuten.Service;

import com.web.rakuten.Model.Users;
import com.web.rakuten.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersService {
    
    public final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void registerUser(Users user){

        usersRepository.save(user);
    }
}
