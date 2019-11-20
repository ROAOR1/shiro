package top.shiro_demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shiro_demo.user.mapper.PermMapper;

import java.util.Set;

@Service
public class PermServiceImpl implements PermService {

    @Autowired
    private PermMapper permMapper;

    @Override
    public Set<String> selectByPermIds(String[] perms) {
        return permMapper.selectByPermIds(perms);
    }
}
