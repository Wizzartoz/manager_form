package com.task.mysolve.controller;

import com.task.mysolve.dto.HobbyDto;
import com.task.mysolve.mapper.HobbyMapper;
import com.task.mysolve.model.Gender;
import com.task.mysolve.service.HobbyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/hobbies")
public class HobbyController {
    private final HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping("/{gender}")
    public ResponseEntity<List<HobbyDto>> getHobbyListBuGender(@PathVariable Gender gender) {
        log.debug("get hobbies by gender: " + gender);
        return ResponseEntity.ok(hobbyService.getHobbiesByGender(gender).stream()
                .map(HobbyMapper::toHobbyDto)
                .collect(Collectors.toList()));
    }
}
