package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {

    @RequestMapping("/home")
    public String index(Model model) {
        System.out.println("Hello Controller");
        model.addAttribute("name", "subhankar");
       
        return "home";
    }

    //about router 
@RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

    //services router 
    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }

    
}
