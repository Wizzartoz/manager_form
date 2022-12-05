package com.task.mysolve.controller;

import com.task.mysolve.dto.FormDto;
import com.task.mysolve.dto.ShortFormDto;
import com.task.mysolve.exception.FormNotFoundException;
import com.task.mysolve.exception.FormValidationException;
import com.task.mysolve.mapper.FormMapper;
import com.task.mysolve.model.Form;
import com.task.mysolve.response.ErrorMsgResponse;
import com.task.mysolve.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/forms")
public class FormController {
    private final FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public ResponseEntity<List<ShortFormDto>> getFormList() {
        return ResponseEntity.ok(formService.findAll().stream()
                .map(FormMapper::toShortFormDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormDto> getForm(@PathVariable String id) {
        log.debug("get form by id: " + id);
        return ResponseEntity.ok(FormMapper.toFormDto(formService.getFormById(id)));

    }

    @PostMapping
    public ResponseEntity<FormDto> updateOrInsertForm(@RequestBody @Valid FormDto formDto, BindingResult binding) {
        if (binding.hasErrors()) {
            log.warn("insert form has invalid fields: " + formDto);
            throw new FormValidationException(binding.toString());
        }
        Form form = formService.createOrUpdateIfExist(FormMapper.toForm(formDto));
        return ResponseEntity.ok(FormMapper.toFormDto(form));
    }

    @DeleteMapping({"/{id}"})
    public HttpStatus deleteForm(@PathVariable String id) {
        formService.delete(id);
        log.debug(String.format("the form with id: %s was delete", id));
        return HttpStatus.OK;
    }

    @ExceptionHandler(value = {FormNotFoundException.class, FormValidationException.class})
    public ResponseEntity<ErrorMsgResponse> handlePersonValidationException(Exception e) {
        log.warn("some error", e);
        return ResponseEntity.badRequest()
                .body(new ErrorMsgResponse(e.getMessage()));
    }
}
