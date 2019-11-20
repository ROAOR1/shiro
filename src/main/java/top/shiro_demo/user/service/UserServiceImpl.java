package top.shiro_demo.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shiro_demo.user.entity.User;
import top.shiro_demo.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("phone",phone));
    }
}
