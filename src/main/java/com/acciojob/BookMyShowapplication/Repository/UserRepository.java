package com.acciojob.BookMyShowapplication.Repository;

import com.acciojob.BookMyShowapplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailId(String emailId);
}
