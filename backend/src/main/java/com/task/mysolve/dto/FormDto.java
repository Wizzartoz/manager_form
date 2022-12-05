package com.task.mysolve.dto;

import com.task.mysolve.model.Gender;
import com.task.mysolve.model.Hobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private String id;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 50)
    private String surname;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 50)
    private String patronymic;
    @NotNull
    @Min(1900)
    @Max(2100)
    private Integer dob;
    @NotNull
    private Gender gender;
    List<Hobby> hobbies;
}
