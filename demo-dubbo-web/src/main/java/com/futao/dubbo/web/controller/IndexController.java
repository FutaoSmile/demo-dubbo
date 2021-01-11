package com.futao.dubbo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 *
 * @author ft
 * @date 2021/1/11
 */
@RequestMapping
@Controller
public class IndexController {

    @GetMapping({"/index", "/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("indexPage");
        modelAndView.addObject("username", "付韬");
        return modelAndView;
    }
}
