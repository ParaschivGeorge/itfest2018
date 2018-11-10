package com.twoguysonepanda.itfest2018.repository;

import com.twoguysonepanda.itfest2018.entities.User;
import com.twoguysonepanda.itfest2018.entities.enums.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "User", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(@Param("email") String email);
    List<User> findAllByType(UserType type);
}
