package top.shiro_demo.user.service;

import java.util.Set;

public interface PermService {
    Set<String> selectByPermIds(String[] perms);
}
