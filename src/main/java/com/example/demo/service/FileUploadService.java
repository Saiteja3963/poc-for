package com.example.demo.service;

import com.example.demo.collections.User;
import com.example.demo.repository.FileUploadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FileUploadService {

    public final FileUploadRepository fileUploadRepository;

    @Transactional
    public void saveUserData(List<String> userString) {
        User user = new User();
        user.setUserName(userString.get(0));
        user.setFirstName(userString.get(1));
        user.setLastName(userString.get(2));
        user.setRollNumber(userString.get(3));

        log.info("Saving user to db: {}", user);
        fileUploadRepository.save(user);
    }

    public User getUser(String userName) {
        Optional<User> optionalUser = fileUploadRepository.findByUserName(userName);
        User user = new User();
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            log.info("Fetched User details from db: {}", user);
        }
        return user;
    }
}
