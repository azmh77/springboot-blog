package com.rhpm.testapp.modules.model.posts;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rhpm.testapp.modules.model.users.User;
import jakarta.persistence .*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Post_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Post {

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private User user;

    @ManyToMany()
    @JoinTable(name = "post_category")
    private List<Category> category;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;
    @Column(name = "post_title")
    private String title;
    @Column(name = "post_description")
    private String description;
    @Column(name = "post_cover")
    private String cover;

    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
