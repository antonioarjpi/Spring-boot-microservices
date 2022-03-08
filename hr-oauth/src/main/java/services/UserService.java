package services;

import feignclients.UserFeignClients;
import lombok.AllArgsConstructor;
import model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserFeignClients userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        if (user == null){
            throw new IllegalArgumentException("E-mail not found");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClients.findByEmail(username).getBody();
        if (user == null){
            throw new UsernameNotFoundException("E-mail not found");
        }
        return user;
    }
}
