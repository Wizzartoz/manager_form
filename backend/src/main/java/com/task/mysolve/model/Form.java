package com.task.mysolve.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Document("form")
public class Form {
    @Id
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
    @DBRef
    List<Hobby> hobbies;
}
