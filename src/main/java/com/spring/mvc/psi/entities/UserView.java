package com.spring.mvc.psi.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
@Immutable // 只能查詢
//@Synchronize({"T_User"}) // 資料與 T_USER 同步
//@Subselect("SELECT u.id, u.\"NAME\", u.EMAIL, u.BIRTH, \n"
//         + "YEAR(CURRENT_DATE)-YEAR(u.birth) as AGE\n"
//         + "FROM T_USER u")
@Table(name = "T_USERADDAGE")
public class UserView {
    @Id
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date birth;
    
    @Column
    private Integer age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserView{" + "id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + ", age=" + age + '}';
    }

    
    
}
