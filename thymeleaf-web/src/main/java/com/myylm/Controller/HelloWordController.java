package com.myylm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author hmmzhtx
 */
@Controller
public class HelloWordController {

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
