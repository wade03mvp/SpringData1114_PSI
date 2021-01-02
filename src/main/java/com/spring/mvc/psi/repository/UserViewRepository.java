package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserViewRepository extends JpaRepository<UserView, Long>{
}
