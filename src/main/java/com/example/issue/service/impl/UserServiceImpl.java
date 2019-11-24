package com.example.issue.service.impl;

import com.example.issue.entity.User;
import com.example.issue.Repository.UserRepository;
import com.example.issue.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User save(User user){
        if (user.getEmail()==null){
            throw new IllegalArgumentException("E-mail cannot be null");
        }
        user=userRepository.save(user);
        return user;
    }
    @Override
    public User getById(Long id){
        return userRepository.getOne(id);
    }
    @Override
    public Page<User>getAllPageable(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
