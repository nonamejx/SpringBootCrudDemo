package com.noname.interest.SpringBootCrudDemo.repository;

import com.noname.interest.SpringBootCrudDemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
