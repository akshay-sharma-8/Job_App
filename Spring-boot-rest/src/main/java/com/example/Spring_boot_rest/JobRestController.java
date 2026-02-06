package com.example.Spring_boot_rest;


import com.example.Spring_boot_rest.model.JobPost;
import com.example.Spring_boot_rest.model.User;
import com.example.Spring_boot_rest.service.JobService;
import com.example.Spring_boot_rest.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

//@CrossOrigin is used in Spring Boot to allow requests from a different origin (domain/port/protocol).
//It solves browser CORS restrictions for frontend-backend communication
public class JobRestController {

    @Autowired
    private JobService service;

    @Autowired
    private Register register;


    @GetMapping(path="jobPosts", produces = {"application/json"})
    //@ResponseBody // use with @Controller
   // @ResponseBody tells Spring “don’t look for an HTML page,
    // just send this object back as the HTTP response (usually JSON)”.
    public List<JobPost> getAllJobs(){
        return service.getalljobs();
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
     return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> findbykeyword(@PathVariable("keyword") String keyword){
        return  service.findbykeyword(keyword);
    }

//    @PostMapping("jobPost")
//    public void addJob(@RequestBody JobPost jobPost){
//        service.addjob(jobPost);
//    }

    @PostMapping(path = "jobPost" , consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addjob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
       return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{jobpostId}")
    public String deleteJob(@PathVariable("jobpostId") int jobPostId){
        service.deleteJob(jobPostId);
        return "Deleted";
    }



    @GetMapping("load")
   public String load(){
        service.load();
        return "success";
   }

   @PostMapping("/Register")
    public User registeruser(@RequestBody User user){

        return register.SaveUser(user);
   }

}

//@PathVariable → identity of the resource (like user ID).
//Tells Spring to fetch the value of postId from the URL.
//PathVariable → mandatory part of the URL (/jobPost/101)


//
//@RestController is just a convenience annotation that combines
//@Controller and @ResponseBody, mainly used for building RESTful web services,
//while @Controller is for traditional MVC apps where you return views.


//Representational State Transfer(REST)

//HTTP stands for HyperText Transfer Protocol.
//It is the standard protocol used for communication between a client,
//like a web browser, and a server over the internet.
//For example, when you type a website URL,
//the browser sends an HTTP request to the server,
//and the server responds with the web page