package com.rhpm.testapp.modules.model.users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rhpm.testapp.modules.enums.Roles;
import com.rhpm.testapp.modules.model.posts.Post;
import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "User_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {

    @OneToMany(mappedBy = "user")
    private List<Post> post;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "authorities" , joinColumns = @JoinColumn
            (name = "email",referencedColumnName = "user_email"))
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;

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

    private boolean enable = true;
}
