package com.microservice.user.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.user.service.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
