package com.fittest.userdoc.repository;

import com.fittest.userdoc.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface UserMDRepository extends MongoRepository<UserMongo, UUID> {
}