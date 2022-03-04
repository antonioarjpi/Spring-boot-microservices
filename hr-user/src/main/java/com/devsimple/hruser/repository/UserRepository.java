package com.devsimple.hruser.repository;

import com.devsimple.hruser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    List<User> findByEmail(String email);
}
