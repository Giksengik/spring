package ru.vlasov.MVCFirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name ,
                            @RequestParam(value = "surname",required = false) String surname,
                            Model model) {

        //System.out.println("Hello "+name+" "+surname);
        model.addAttribute("message","Hello "+name+" "+surname);
        return("first/hello");
    }
    @GetMapping("goodbye")
    public String goodByePage(){
        return("first/goodbye");
    }
    @GetMapping("calculator")
    public String calculate(@RequestParam(value = "a")int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "action") String action,Model model){
        if(action.equals("multiplication")){
            model.addAttribute("result",a*b);
        }else if(action.equals("addition")){
            model.addAttribute("result",a+b);
        }else if(action.equals("subtraction")){
            model.addAttribute("result",a-b);
        }else if(action.equals("division")){
            if(b==0) model.addAttribute("result","infinity");
            else model.addAttribute("result",a/b);
        }
        return("first/calculator");
    }
}
