package com.task.mysolve.dto;

import com.task.mysolve.model.Gender;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HobbyDto {
    private String id;
    @NotNull
    private Gender gender;
    @NotNull
    @NotEmpty
    private String name;
}
