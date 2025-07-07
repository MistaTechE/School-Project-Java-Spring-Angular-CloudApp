package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {
    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showPresentation(){
        String finalMessage= "Join us for an online live presentation";
        return finalMessage;
    }

}
