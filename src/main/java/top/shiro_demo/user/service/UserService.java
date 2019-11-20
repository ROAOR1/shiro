package top.shiro_demo.user.service;

import top.shiro_demo.user.entity.User;

public interface UserService {
    User selectByPhone(String phone);
}
