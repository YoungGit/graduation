package com.younggit.graduation.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lizhouyang on 15/10/20.
 */
@Entity
@Table(name = "item")
public class ItemEntity {
    private Integer id;
    private String name;
    private Integer aspectNum;
    private String aspectSeed;
    private String aspectWords;
    private Collection<CommentEntity> commentsById;
    private CategoryEntity category;

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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 200)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (id != that.id) return false;
        if (category != that.category) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (aspectNum != null ? !aspectNum.equals(that.aspectNum) : that.aspectNum != null) return false;
        if (aspectSeed != null ? !aspectSeed.equals(that.aspectSeed) : that.aspectSeed != null) return false;
        if (aspectWords != null ? !aspectWords.equals(that.aspectWords) : that.aspectWords != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (aspectNum != null ? aspectNum.hashCode() : 0);
        result = 31 * result + (aspectSeed != null ? aspectSeed.hashCode() : 0);
        result = 31 * result + (aspectWords != null ? aspectWords.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "item")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
