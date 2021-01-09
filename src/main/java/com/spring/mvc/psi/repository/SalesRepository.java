package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Sales;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer>{
    
}
