package com.rhpm.testapp.modules.model.users;

import com.rhpm.testapp.modules.model.posts.Post;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_phoneNumber")
    private long phoneNumber;
}