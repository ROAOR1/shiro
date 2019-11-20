package top.shiro_demo.user.service;

import top.shiro_demo.user.entity.UserPerm;

public interface UserPermService {
    UserPerm selectByUserId(Integer userId);
}
