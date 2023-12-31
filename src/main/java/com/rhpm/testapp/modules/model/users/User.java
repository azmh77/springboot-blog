package com.rhpm.testapp.modules.model.users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rhpm.testapp.modules.enums.Role;
import com.rhpm.testapp.modules.model.posts.Post;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "User_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Post> post;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "authorities" , joinColumns = @JoinColumn
            (name = "email",referencedColumnName = "user_email"))
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_phoneNumber")
    private String phoneNumber;
    @Column(name = "user_cover")
    private String cover;

    private boolean enable = true;
}
