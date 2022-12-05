package com.task.mysolve.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document("hobby")
public class Hobby {
    @Id
    private String id;
    @NonNull
    private Gender gender;
    @NotNull
    @NotEmpty
    private String name;
}
