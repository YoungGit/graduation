package com.younggit.graduation.entity;

import javax.persistence.*;

/**
 * Created by lizhouyang on 15/10/20.
 */
@Entity
@Table(name = "comment")
public class CommentEntity {
    private int id;
    private String url;
    private String raw;
    private String segment;
    private CategoryEntity category;
    private ItemEntity item;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "raw", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Basic
    @Column(name = "segment", nullable = true, insertable = true, updatable = true, length = 3000)
    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (raw != null ? !raw.equals(that.raw) : that.raw != null) return false;
        if (segment != null ? !segment.equals(that.segment) : that.segment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (raw != null ? raw.hashCode() : 0);
        result = 31 * result + (segment != null ? segment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}
