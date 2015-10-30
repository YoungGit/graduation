package com.younggit.graduation.entity;

import javax.persistence.*;

/**
 * Created by lizhouyang on 15/10/20.
 */
@Entity
@Table(name = "comment")
public class CommentEntity {
    private int id;
    private String raw;
    private String pos;
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
    @Column(name = "raw", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Basic
    @Column(name = "pos", nullable = true, insertable = true, updatable = true, length = 3000)
    public String getPos() {
        return pos;
    }

    public void setPos(String segment) {
        this.pos = segment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (raw != null ? !raw.equals(that.raw) : that.raw != null) return false;
        if (pos != null ? !pos.equals(that.pos) : that.pos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (raw != null ? raw.hashCode() : 0);
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}
