package com.example.daytwozuoyetwo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DatasBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String author;
    private String avatar;
    @Generated(hash = 622817568)
    public DatasBean(Long id, String title, String author, String avatar) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.avatar = avatar;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
