package net.bookmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "")
    public String main(Model model) {
        model.addAttribute("message", "вапсм");
        return "hello";
    }
}
