package com.rhpm.testapp.modules.model.posts;

import jakarta.persistence .*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category_tbl")
@Data
public class Category {

    @ManyToMany(mappedBy = "category")
    private List<Post> posts;

    @Id
    @GeneratedValue()
    @Column(name = "category_id")
    private long id;
    @Column(name = "category_title")
    private String title;
}
