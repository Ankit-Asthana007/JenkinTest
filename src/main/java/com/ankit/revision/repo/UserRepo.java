package com.ankit.revision.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ankit.revision.model.User;
public interface UserRepo extends JpaRepository<User, Long> {
}
