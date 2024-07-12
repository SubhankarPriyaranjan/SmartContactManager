package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;




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

    //contact router 
    @RequestMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    //login router 
    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    //register router 
    @RequestMapping("/register")
    public String Register(){
//         UserForm userForm = new UserForm();
    
// model.addAttribute("userform", userForm);

        return "register";
    }
    
    
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(){
        //fetch from data

        return "redirect:/register";
    }
}
