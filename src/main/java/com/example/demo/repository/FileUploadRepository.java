package com.example.demo.repository;

import com.example.demo.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepository extends MongoRepository<User, String> {

    public Optional<User> findByUserName(String userName);
}
