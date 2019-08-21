package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("user")
public class LoginController {
//    /*add user in model attribute*/
//    @ModelAttribute("user")
//    public User setUpUserForm() {
//        return new User();
//    }

    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public String login(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
//        Cookie cookie = new Cookie("setUser", setUser);
//        model.addAttribute("cookieValue", cookie);
//        return "/login/login";
//    }
    @GetMapping("/login")
    public  ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login/login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView handlingFormLogin(@ModelAttribute("user") User users, HttpSession session, Model model)
//                                          @CookieValue(value = "setUser", defaultValue = "") String setUser, HttpServletResponse response, HttpServletRequest request)
    {
        User user = userService.findByName(users.getName());
        if ((user != null) && (user.getName().equals(users.getName())) &&
                (user.getPassword().equals(users.getPassword()))) {

//            setUser = users.getName();
//
//            // create cookie and set it in response
//            Cookie cookie = new Cookie("setUser", setUser);
//            cookie.setMaxAge(24 * 60 * 60);
//            response.addCookie(cookie);
//            //get all cookies
//            Cookie[] cookies = request.getCookies();
//            //iterate each cookie
//            for (Cookie ck : cookies) {
//                //display only the cookie with the name 'setUser'
//                if (ck.getName().equals("setUser")) {
//                    model.addAttribute("cookieValue", ck);
//                    break;
//                } else {
//                    ck.setValue("");
//                    model.addAttribute("cookieValue", ck);
//                    break;
//                }
//            }
            ModelAndView modelAndView = new ModelAndView("redirect:/list");
            session.setAttribute("myUser", user.getName());
            return modelAndView;
        } else {
//            users.setName(" ");
            ModelAndView modelAndView = new ModelAndView("/login/login");
            modelAndView.addObject("message", "login fail ... !");
            return modelAndView;
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
