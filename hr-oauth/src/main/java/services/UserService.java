package services;

import feignclients.UserFeignClients;
import lombok.AllArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserFeignClients userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        if (user == null){
            throw new IllegalArgumentException("E-mail not found");
        }
        return user;
    }
}
