package com.sensedia.lab5.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {

    @RequestMapping(value = ["/"])
    fun index(): ModelAndView {
        return ModelAndView("index")
    }
}