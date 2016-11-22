package com.post.depricated;

//@Controller
//@RequestMapping("/tests")
public class PostController {

//    @Autowired
//    PostRepository postRepository;
//
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public String listPosts(Model model){
//        model.addAttribute("tests", postRepository.findAll());
//        return "tests/list";
//    }
//
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
//    public ModelAndView modelAndView(@PathVariable long id){
//        postRepository.delete(id);
//        return new ModelAndView("redirect:/tests");
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public String newProject(){
//        return "tests/new";
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ModelAndView create(@RequestParam("message") String comment){
//        postRepository.save(new Post(comment));
//        return new ModelAndView("redirect:/tests");
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ModelAndView update(@RequestParam("post_id") long id, @RequestParam("message") String message){
//        Post post = postRepository.findOne(id);
//        post.setMessage(message);
//        postRepository.save(post);
//        return new ModelAndView("redirect:/tests");
//    }
//
//    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
//    public String edit(@PathVariable long id,
//                       Model model) {
//        Post post = postRepository.findOne(id);
//        model.addAttribute("post", post);
//        return "tests/edit";
//    }
}
