package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;









@Controller
public class HomeController {


    @Autowired
private UserService userService;

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
    public String Register(Model model){
      UserForm userForm = new UserForm();
    
     
      
 model.addAttribute("userform", userForm);

        return "register";
    }
    
    
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister( @ModelAttribute UserForm userForm ){
        //fetch from data

        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout()).phone_number(userForm.getPhoneNumber()).proflePic("").build();


        User user=new User();
       user.setName(userForm.getName());
       user.setEmail(userForm.getEmail());
       user.setPassword(userForm.getPassword());
       user.setAbout(userForm.getAbout());
       user.setPhone_number(userForm.getPhoneNumber());
       user.setProflePic("asdfgh.jpeg");
      
       
       User savedUser= userService.saveUser(user);
      System.out.println("User Saved"+savedUser);
       
        return "redirect:/register";
    }
}
