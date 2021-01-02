package com.spring.mvc.psi.entities;

import javax.persistence.Entity;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
@Immutable // 只能查詢
@Synchronize({"T_User"}) // 資料與 T_USER 同步
@Subselect("SELECT u.id, u.\"NAME\", u.EMAIL, u.BIRTH, \n"
         + "YEAR(CURRENT_DATE)-YEAR(u.birth) as AGE\n"
         + "FROM T_USER u")
public class UserView extends User {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getId() + ", " + getName() + ", " + getEmail() + ", " + getBirth() + "," + getAge() + "\n";
    }

    
}
