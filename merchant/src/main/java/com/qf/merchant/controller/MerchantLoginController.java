package com.qf.merchant.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author-izumi
 */
@Controller
public class MerchantLoginController {

    @RequestMapping({"/","login"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login.do")
    public String doLogin(Model model,
                          @RequestParam(value = "username",required = true) String username,
                          @RequestParam(value = "password",required = true) String password){
        //String类型默认值为"",Integer类型默认为null
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                return "forward:toIndex";
            }
        }catch (AuthenticationException e){
        }
        model.addAttribute("error", "账号或密码错误！");
        return "forward:/";
    }
}
