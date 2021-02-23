package com.example.bookStore.repo;

import com.example.bookStore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}
