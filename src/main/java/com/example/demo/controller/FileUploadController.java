package com.example.demo.controller;

import com.example.demo.collections.User;
import com.example.demo.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("/hello/{userDetails}")
    public ResponseEntity uploadExcelFile(@PathVariable List<String> userDetails) {
        log.info("Request received to upload the file: {}", userDetails);
        fileUploadService.saveUserData(userDetails);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) {
        log.info("Request received to get the user by user name: {}", userName);
        User user = fileUploadService.getUser(userName);
        return ResponseEntity.ok(user);
    }
}
