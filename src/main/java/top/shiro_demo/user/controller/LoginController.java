package top.shiro_demo.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(String phone, String password){
        SecurityUtils.getSubject().login(new UsernamePasswordToken(phone,password));
    }

    @GetMapping("/logout")
    public void logout(){
        SecurityUtils.getSubject().logout();
    }
}
