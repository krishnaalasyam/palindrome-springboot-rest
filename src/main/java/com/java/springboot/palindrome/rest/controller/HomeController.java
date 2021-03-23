package com.java.springboot.palindrome.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main page controller
 */
@Controller
@RequestMapping("/home")
@SuppressWarnings("unused")
public class HomeController {
    /**
     * Logger factory.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Goes to the landing page of application.
     *
     * @return Home page view.
     */
    @RequestMapping("")
    public String index(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("index started");
        }
        return "home/index";
    }
}
