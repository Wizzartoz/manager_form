package com.task.mysolve.service;

import com.task.mysolve.exception.FormNotFoundException;
import com.task.mysolve.model.Form;
import com.task.mysolve.repository.FormRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormServiceImpl implements FormService {
    private static final String PERSON_NOT_FOUND_EXCEPTION = "person with id:%s not found";
    private final FormRepository repository;

    @Autowired
    public FormServiceImpl(FormRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Form> findAll() {
        return repository.findAll();
    }

    @Override
    @SneakyThrows(FormNotFoundException.class)
    public Form getFormById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new FormNotFoundException(String.format(PERSON_NOT_FOUND_EXCEPTION, id)));
    }

    @Override
    public Form createOrUpdateIfExist(Form form) {
        return repository.save(form);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
