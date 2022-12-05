package com.task.mysolve.repository;

import com.task.mysolve.model.Gender;
import com.task.mysolve.model.Hobby;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends MongoRepository<Hobby, String> {
    List<Hobby> getHobbiesByGender(Gender gender);
}
