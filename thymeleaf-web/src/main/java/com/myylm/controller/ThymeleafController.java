package com.myylm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hmmzhtx
 */
@Controller
public class ThymeleafController {


    protected static Logger logger= LoggerFactory.getLogger(ThymeleafController.class);

    /**
     * Thymeleaf
     * @param model
     * @return
     */
    @RequestMapping("/toThy")
    public String index(Model model){
        logger.info("info");
        logger.error("error");
        logger.trace("trace");
        model.addAttribute("name", "11111");
        return "thy";
    }


}
