package com.myylm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hmmzhtx
 */
@Controller
public class ThymeleafController {



    /**
     * Thymeleaf
     * @param model
     * @return
     */
    @RequestMapping("/toThy")
    public String index(Model model){
        model.addAttribute("name", "11111");
        return "thy";
    }


}
