package com.rhpm.testapp.modules.model.users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rhpm.testapp.modules.enums.Role;
import com.rhpm.testapp.modules.model.posts.Post;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "User_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Post> post;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "authorities" , joinColumns = @JoinColumn
            (name = "email",referencedColumnName = "email"))
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_phoneNumber")
    private long phoneNumber;

    private boolean enable = true;
}
