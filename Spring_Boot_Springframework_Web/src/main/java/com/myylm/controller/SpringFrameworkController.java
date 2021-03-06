package com.myylm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author hmmzhtx
 */
@Controller
public class SpringFrameworkController {

    /**
     * freemarker
     * @param modelMap
     * @return
     */
    @RequestMapping("/toFree")
    public ModelAndView free(ModelMap modelMap){
        modelMap.put("user","1111");
        return new ModelAndView("free",modelMap);
    }


    /**
     * freemarker
     * @param map
     * @return
     */
    @RequestMapping("/toFreeOne")
    public String freeOne(Map<String, Object> map){
        map.put("user","11");
        return "free";
    }




}
