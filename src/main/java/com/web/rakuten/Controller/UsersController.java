package com.web.rakuten.Controller;

import com.web.rakuten.Model.AuthenticationRequest;
import com.web.rakuten.Model.AuthenticationResponse;
import com.web.rakuten.Model.Users;
import com.web.rakuten.Service.RakutenUserDetailsService;
import com.web.rakuten.Service.UsersService;
import com.web.rakuten.Util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private RakutenUserDetailsService rakutenUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
                )
            );
        } catch (Exception e) {
            //TODO: handle exception
            throw new Exception("Incorrect username or password!",e);
        }

        final UserDetails userDetails = rakutenUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(token);
    }
    
    
}
