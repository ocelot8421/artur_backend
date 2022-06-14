package com.artur.intakes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.artur.intakes.model.User;

public interface UserRepository extends CrudRepository<User, Integer> { //>>3.

}
