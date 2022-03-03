package com.hostell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hostell.model.model;


@RestController
@Controller
public class HostellController {
    @RequestMapping("/hostell")
    public @ResponseBody model getMessage(){
    	model model = new model();
        model.setMessage("Hello World");
        return model;
    }
 
}
