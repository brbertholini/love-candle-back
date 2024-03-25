package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.User;
import com.lovecandle.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        // fazer exception
        return obj.orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            return null;
        }
        return null;
    }

    public User updateUser(Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    public void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
