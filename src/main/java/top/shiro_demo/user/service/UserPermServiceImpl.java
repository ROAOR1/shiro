package top.shiro_demo.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shiro_demo.user.entity.UserPerm;
import top.shiro_demo.user.mapper.UserPermMapper;

@Service
public class UserPermServiceImpl implements UserPermService {

    @Autowired
    private UserPermMapper userPermMapper;

    @Override
    public UserPerm selectByUserId(Integer userId) {
        return userPermMapper.selectOne(new QueryWrapper<UserPerm>().eq("user_id",userId));
    }
}
