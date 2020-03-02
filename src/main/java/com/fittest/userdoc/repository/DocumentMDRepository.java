package com.fittest.userdoc.repository;

import com.fittest.userdoc.entity.DocMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DocumentMDRepository extends MongoRepository<DocMongo, UUID> {
    List<DocMongo> findByUserIdAndDateAfter(UUID userId, Date date);
    void deleteByUserId(UUID userId);
}
