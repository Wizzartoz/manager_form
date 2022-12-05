package com.task.mysolve.service;

import com.task.mysolve.model.Gender;
import com.task.mysolve.model.Hobby;
import com.task.mysolve.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository repository;

    @Autowired
    public HobbyServiceImpl(HobbyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Hobby> getHobbiesByGender(Gender gender) {
        return repository.getHobbiesByGender(gender);
    }
}
