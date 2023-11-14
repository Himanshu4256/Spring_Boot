package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.crud.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{

}
