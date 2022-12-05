package com.task.mysolve.service;

import com.task.mysolve.model.Form;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    List<Form> findAll();

    Form getFormById(String id);

    Form createOrUpdateIfExist(Form form);

    void delete(String id);
}
