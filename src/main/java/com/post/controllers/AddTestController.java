package com.post.controllers;

import com.post.domain.Answer;
import com.post.domain.Question;
import com.post.domain.Test;
import com.post.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("/tests")
@SessionAttributes("newTest")
public class AddTestController {

    @Autowired
    TestService testService;

    @RequestMapping("/new-test")
    public ModelAndView newTest() {
        Test test = new Test();
        test.setQuestions(new ArrayList<Question>());
        Question question = new Question("Вопрос", test, true, test.getQuestions().size());
        question.setAnswers(new ArrayList<Answer>());
        test.getQuestions().add(question);
//        return test;
//        model.addAttribute(test);
//        return "tests/new";
        return new ModelAndView("tests/new-test", "newTest", test);
    }

//    @ModelAttribute("test")
//    public Test test() {
//        Test test = new Test();
//        test.setQuestions(new ArrayList<Question>());
//        test.setName("testing");
//        return test;
//    }

    @RequestMapping(value = "/add-question", method = RequestMethod.GET)
    public String addQuestion(@ModelAttribute("newTest") Test test, Model model) {
        Question question = new Question("Вопрос", test, true, test.getQuestions().size());
        question.setAnswers(new ArrayList<Answer>());
        test.getQuestions().add(question);

        model.addAttribute("newTest", test);

        return "tests/new-test";
    }

    @RequestMapping(value = "/add-answer/{index}", method = RequestMethod.GET)
    public String addAnswer(@PathVariable int index, @ModelAttribute("newTest") Test test, Model model) {

        for (Question question : test.getQuestions()) {
            if (question.getIndex() == index) {
                question.getAnswers().add(new Answer());
            }
        }
        return "tests/new-test";
    }


    @RequestMapping(value = "/delete-answer/{index}", method = RequestMethod.GET)
    public String deleteAnswer(@PathVariable int index, @ModelAttribute("newTest") Test test, Model model) {

        for (Question question : test.getQuestions()) {
            if (question.getIndex() == index) {
                Iterator<Answer> iterator = question.getAnswers().iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    if (!iterator.hasNext()) {
                        iterator.remove();
                    }
                }
            }
        }

//        model.addAttribute("newTest", test);

        return "tests/new-test";
    }

    @RequestMapping(value = "/new", params = {"addRow"})
    public String addRow(Test test, final BindingResult bindingResult, Model model) {
        test.getQuestions().add(new Question());
        return "tests/new";
    }

    @RequestMapping(value = "/save-test", method = RequestMethod.GET)
    public String saveTest(@ModelAttribute("newTest") Test test, SessionStatus ss, Model model) {

        testService.saveTest(test);
        ss.setComplete();

        return "tests/";
    }
}
