package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // 根據 name 來取得 User
    User getByName(String name);
    
}
