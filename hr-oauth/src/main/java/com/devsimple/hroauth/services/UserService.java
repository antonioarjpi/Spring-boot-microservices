package com.devsimple.hroauth.services;

import com.devsimple.hroauth.feignclients.UserFeignClient;
import com.devsimple.hroauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        if (user == null){
            throw new IllegalArgumentException("E-mail not found");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClients.findByEmail(email).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }
}
