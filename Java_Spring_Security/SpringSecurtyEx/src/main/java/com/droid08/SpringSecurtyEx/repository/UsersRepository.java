package com.droid08.SpringSecurtyEx.repository;

import com.droid08.SpringSecurtyEx.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
