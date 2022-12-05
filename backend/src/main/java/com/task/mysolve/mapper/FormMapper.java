package com.task.mysolve.mapper;

import com.task.mysolve.dto.FormDto;
import com.task.mysolve.dto.ShortFormDto;
import com.task.mysolve.model.Form;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FormMapper {
    public ShortFormDto toShortFormDto(Form form) {
        return ShortFormDto.builder()
                .id(form.getId())
                .surname(form.getSurname())
                .name(form.getName())
                .patronymic(form.getPatronymic())
                .build();

    }

    public FormDto toFormDto(Form form) {
        return FormDto.builder()
                .id(form.getId())
                .surname(form.getSurname())
                .name(form.getName())
                .patronymic(form.getPatronymic())
                .dob(form.getDob())
                .gender(form.getGender())
                .hobbies(form.getHobbies())
                .build();

    }

    public Form toForm(FormDto formDto) {
        return Form.builder()
                .id(formDto.getId())
                .name(formDto.getName())
                .surname(formDto.getSurname())
                .patronymic(formDto.getPatronymic())
                .dob(formDto.getDob())
                .gender(formDto.getGender())
                .hobbies(formDto.getHobbies())
                .build();
    }
}
