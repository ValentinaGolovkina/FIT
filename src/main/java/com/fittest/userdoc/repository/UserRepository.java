package com.fittest.userdoc.repository;

import com.fittest.userdoc.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByGuid(UUID guid);
}
