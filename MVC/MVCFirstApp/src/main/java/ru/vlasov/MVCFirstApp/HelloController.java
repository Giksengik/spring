package ru.vlasov.MVCFirstApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    @GetMapping("hello_world")
    public String sayHello() {
        return "/hello_world";
    }
}