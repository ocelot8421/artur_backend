package com.artur.intakes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.artur.intakes.model.User;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends CrudRepository<User, Integer> { //>>3.

}
