package com.lovecandle.demo.entitiy;

import com.lovecandle.demo.entitiy.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.phone = userDTO.getPhone();
        this.password = userDTO.getPassword();
    }
    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

}
