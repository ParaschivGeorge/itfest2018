package com.twoguysonepanda.itfest2018.repository;

import com.twoguysonepanda.itfest2018.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
