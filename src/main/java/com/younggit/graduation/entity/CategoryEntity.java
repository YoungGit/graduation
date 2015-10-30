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
    private Integer aspectNum;
    private String aspectSeed;
    private String aspectWords;
    private Collection<ItemEntity> itemsById;

    /*
    注意！
    mysql中主键用auto_increment时，配合hibernate
    需要设置@GeneratedValue(strategy = GenerationType.IDENTITY)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Basic
    @Column(name = "aspect_num", nullable = true, insertable = true, updatable = true)
    public Integer getAspectNum() {
        return aspectNum;
    }

    public void setAspectNum(Integer aspectNum) {
        this.aspectNum = aspectNum;
    }

    @Basic
    @Column(name = "aspect_seed", nullable = true, insertable = true, updatable = true, length = 500)
    public String getAspectSeed() {
        return aspectSeed;
    }

    public void setAspectSeed(String aspectSeed) {
        this.aspectSeed = aspectSeed;
    }

    @Basic
    @Column(name = "aspect_words", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getAspectWords() {
        return aspectWords;
    }

    public void setAspectWords(String aspectWords) {
        this.aspectWords = aspectWords;
    }

    @OneToMany(mappedBy = "category")
    public Collection<ItemEntity> getItemsById() {
        return itemsById;
    }

    public void setItemsById(Collection<ItemEntity> itemsById) {
        this.itemsById = itemsById;
    }
}
