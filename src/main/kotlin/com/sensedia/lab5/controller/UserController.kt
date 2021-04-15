package com.sensedia.lab5.controller

import com.sensedia.lab5.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.beans.factory.annotation.Autowired

@Controller
class UserController @Autowired constructor(private val userService: UserService) {

    @RequestMapping(value = ["/me"])
    fun getCurrentUser(): ModelAndView {
        var model = mapOf("user" to userService.getCurrentUser())
        return ModelAndView("user", model)
    }
}