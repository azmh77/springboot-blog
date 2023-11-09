package com.rhpm.testapp.modules.model.posts;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence .*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category_tbl")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
