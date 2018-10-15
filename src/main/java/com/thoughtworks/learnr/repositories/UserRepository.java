package com.thoughtworks.learnr.repositories;

import com.thoughtworks.learnr.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
