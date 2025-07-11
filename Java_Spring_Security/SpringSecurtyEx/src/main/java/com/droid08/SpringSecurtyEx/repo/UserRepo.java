package com.droid08.SpringSecurtyEx.repo;

import com.droid08.SpringSecurtyEx.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
}
