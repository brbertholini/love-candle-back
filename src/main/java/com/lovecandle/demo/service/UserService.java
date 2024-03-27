package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.User;
import com.lovecandle.demo.entitiy.dtos.UserDTO;
import com.lovecandle.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }


    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(UserDTO::new);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return new UserDTO(userRepository.save(new User(userDTO)));
    }
    
    public Optional<UserDTO> deleteUser(Long id) {
        Optional<UserDTO> userDTO = this.getUserById(id);
        userRepository.deleteById(id);
        return userDTO;

    }

    public UserDTO updateUser(Long id, UserDTO obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, new User(obj));
        return new UserDTO(userRepository.save(entity));
    }

    public void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }
}
