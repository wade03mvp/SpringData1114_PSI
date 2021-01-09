package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class UserPerformance {
    @Id
    private String name;
    
    @Column
    private Integer profit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }
    
    
}
