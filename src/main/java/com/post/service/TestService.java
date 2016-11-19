package com.post.service;

import com.post.domain.Test;
import com.post.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public Iterable<Test> findAll(){
        return testRepository.findAll();
    }

    public Test findOne(long id){
        return testRepository.findOne(id);
    }

    public void saveTest(Test test){
        testRepository.save(test);
    }
}
