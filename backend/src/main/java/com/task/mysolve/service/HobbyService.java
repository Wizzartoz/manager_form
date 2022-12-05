package com.task.mysolve.service;

import com.task.mysolve.model.Gender;
import com.task.mysolve.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HobbyService {
    List<Hobby> getHobbiesByGender(Gender gender);
}
