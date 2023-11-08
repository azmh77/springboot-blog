package com.rhpm.testapp.modules.model.posts;

import com.rhpm.testapp.modules.model.users.User;
import jakarta.persistence .*;
import lombok.Data;
@Entity
@Data
@Table(name = "Post_tbl")
public class Post {

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;
    @Column(name = "post_title")
    private String title;
    @Column(name = "post_description")
    private String description;
}
