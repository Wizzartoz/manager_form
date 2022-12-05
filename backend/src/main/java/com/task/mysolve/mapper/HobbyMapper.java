package com.task.mysolve.mapper;

import com.task.mysolve.dto.HobbyDto;
import com.task.mysolve.model.Hobby;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HobbyMapper {
    public HobbyDto toHobbyDto(Hobby hobby) {
        return HobbyDto.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .gender(hobby.getGender())
                .build();
    }

    public Hobby toHobby(HobbyDto hobbyDto) {
        return Hobby.builder()
                .id(hobbyDto.getId())
                .name(hobbyDto.getName())
                .gender(hobbyDto.getGender())
                .build();
    }
}
