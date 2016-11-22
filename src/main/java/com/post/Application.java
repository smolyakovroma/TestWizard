package com.post;

import com.post.domain.Answer;
import com.post.domain.Question;
import com.post.domain.Test;
import com.post.repository.QuestionRepository;
import com.post.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;
//
//    @Autowired
//    AnswerRepository answerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Test test;
        for (int i = 0; i < 5; i++) {
            test = new Test("Test #" + (i + 1), "Description for test");
            test.setSinglepage(i%2==0?true:false);
            ArrayList<Question> questions = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Question question;
                if (j % 2 == 0) {
                    question = new Question("Question #" + (j + 1), test, true, j);
                } else {
                    question = new Question("Question #" + (j + 1), test, false, j);
                }

                questions.add(question);
                ArrayList<Answer> answers = new ArrayList<>();
                for (int k = 0; k < 4; k++) {

                    answers.add(new Answer("Answer #" + (k + 1) + " for question #" + (j + 1), question));
                }
                question.setAnswers(answers);
//                questionRepository.save(question);
//                answerRepository.save(answers);
            }
            test.setQuestions(questions);
            testRepository.save(test);
            questionRepository.save(questions);
        }
    }
}
