package com.thoughtworks.learnr.repositories;

import com.thoughtworks.learnr.models.Trainings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends MongoRepository<Trainings, String> {

}
