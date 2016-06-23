package cj.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cj")
public class Login{

    @RequestMapping("")
    public String login(){
        return "page/index";
    }
}