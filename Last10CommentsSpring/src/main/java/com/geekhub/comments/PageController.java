package com.geekhub.comments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PageController {

    @GetMapping("/")
    public String indexPage(ModelMap model) {
        return "index";
    }
}
