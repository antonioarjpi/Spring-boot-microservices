package com.devsimple.hruser.service;

import com.devsimple.hruser.model.User;
import com.devsimple.hruser.repository.UserRepository;
import com.devsimple.hruser.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    @Transactional
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
