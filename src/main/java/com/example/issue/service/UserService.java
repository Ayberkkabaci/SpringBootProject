package com.example.issue.service;

import com.example.issue.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(User user);
    User getById(Long id);
    Page<User> getAllPageable(Pageable pageable);
    User getByUsername(String username);


}
