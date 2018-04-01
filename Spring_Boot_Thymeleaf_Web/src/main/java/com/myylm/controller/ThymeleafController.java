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
     * 跳转到页面
     * @param model
     * @return
     */
    @RequestMapping("/toThy")
    public String index(Model model){
        model.addAttribute("name", "11111");
        return "thy";
    }

    /**
     * Thymeleaf
     * 跳转到执行方法
     * @param model
     * @return
     */
    @RequestMapping("/redirectThy")
    public String toIndex(Model model){
        return "redirect:/toThy";
    }



}
