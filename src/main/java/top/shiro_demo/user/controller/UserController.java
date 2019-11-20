package top.shiro_demo.user.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.shiro_demo.user.entity.User;
import top.shiro_demo.user.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwh
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 需要管理员权限才能访问
     * @param phone
     * @return
     */
    @RequiresPermissions("管理员权限")
    @GetMapping("/selectByPhone")
    public User selectByPhone(String phone){
        return userService.selectByPhone(phone);
    }
}

