package com.post.controllers;

import com.post.domain.Question;
import com.post.domain.Test;
import com.post.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listTests(Model model) {
        model.addAttribute("tests", testService.findAll());
        return "tests/list";
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.GET)
    public String startTest(@PathVariable long id,
                            Model model) {
        Test test = testService.findOne(id);
        model.addAttribute("test", test);
        model.addAttribute("questions", test.getQuestions());
        return "tests/start";
    }

    @RequestMapping(value = "/new-test", method = RequestMethod.GET)
    public String newTest() {
        return "tests/new-test";
    }

    @RequestMapping(value = "/add-test", method = RequestMethod.POST)
    public String addTest(@RequestParam("test_name") String name, @RequestParam("test_description") String description
            ,@RequestParam("singlepage") boolean singlepage, Model model) {
        Test test = new Test(name, description);
        test.setSinglepage(singlepage);
        model.addAttribute("test", test);

        testService.saveTest(test);

        return "tests/new-test";
    }

    @RequestMapping(value = "/add-question", method = RequestMethod.POST)
    public String addQuestion(@RequestParam("question") String question, @RequestParam("id") String id, Model model) {
        Test test = testService.findOne(Long.valueOf(id));
        test.getQuestions().add(new Question(question, test, true));
        model.addAttribute("test", test);
        testService.saveTest(test);
//        testService.saveTest(test);

        return "tests/new-test";
    }
}
