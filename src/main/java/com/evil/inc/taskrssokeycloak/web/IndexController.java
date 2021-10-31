package com.evil.inc.taskrssokeycloak.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public ModelAndView index(@AuthenticationPrincipal OAuth2User principal) {
        final ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("username", principal == null ? null : principal.getAttribute("login"));
        return modelAndView;
    }
}
