package com.core.assignMent.repository;

import com.core.assignMent.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUserId(long userId);
}
