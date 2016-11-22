package com.post.controllers;

import com.post.domain.Test;
import com.post.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tests")
@SessionAttributes("newTest")
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

//    @RequestMapping(value = "/new-test", method = RequestMethod.GET)
//    public ModelAndView newTest(@ModelAttribute("newTest") Test test) {
//
////        return new ModelAndView("tests/new-test", "newTest", new Test("tess","222"));
//        test.setName("222");
//        return new ModelAndView("tests/new-test", "newTest", test);
//
//    }

//    @ModelAttribute("newTest")
//    public  Test make(){
//        Test sss = new Test("sss", "222");
//        return sss;
//    }

//    @RequestMapping(value = "/add-test", method = RequestMethod.POST)
//    public String addTest(@RequestParam("test_name") String name, @RequestParam("test_description") String description
//            ,@RequestParam("singlepage") boolean singlepage, Model model) {
//        Test test = new Test(name, description);
//        test.setSinglepage(singlepage);
//        model.addAttribute("test", test);
//        testService.saveTest(test);
//
//        return "tests/new-test";
//    }
//
//    @RequestMapping(value = "/add-question", method = RequestMethod.POST)
//    public String addQuestion(@RequestParam("question") String question, @RequestParam("id") String id, Model model) {
//        Test test = testService.findOne(Long.valueOf(id));
//
//        Question questionAdd = new Question(question, test, true);
//        questionAdd.setAnswers(Arrays.asList(new Answer()));
//        test.getQuestions().add(questionAdd);
//
//        model.addAttribute("test", test);
//        model.addAttribute("question", questionAdd);
//        testService.saveTest(test);
////        testService.saveTest(test);
//
//        return "tests/new-test";
//    }

}
