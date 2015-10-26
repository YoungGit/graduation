package com.younggit.graduation.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lizhouyang on 15/10/20.
 */
@Entity
@Table(name = "category")
public class CategoryEntity {
    private Integer id;
    private String name;
    private Collection<CommentEntity> commentsById;
    private Collection<ItemEntity> itemsById;

    /*
    注意！
    mysql中主键用auto_increment时，配合hibernate
    需要设置@GeneratedValue(strategy = GenerationType.IDENTITY)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CategoryEntity that = (CategoryEntity) o;
//
//        if (id != that.id) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }

    @OneToMany(mappedBy = "category")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "category")
    public Collection<ItemEntity> getItemsById() {
        return itemsById;
    }

    public void setItemsById(Collection<ItemEntity> itemsById) {
        this.itemsById = itemsById;
    }
}
