package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    @Column(name = "image", columnDefinition = "clob") // clob 文字型代的大資料, blob 二進位型代的大資料
    @Lob
    private String image; // 將圖像轉 base64 後存入
    
    @ManyToOne
    private User user;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
