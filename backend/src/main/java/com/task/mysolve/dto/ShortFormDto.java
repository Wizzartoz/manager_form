package com.task.mysolve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortFormDto {
    private String id;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    private String surname;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    private String patronymic;
}
