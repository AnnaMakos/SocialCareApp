package com.annamakos.socialcare.repository;

import com.annamakos.socialcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
