package top.shiro_demo.common.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.shiro_demo.user.entity.User;
import top.shiro_demo.user.entity.UserPerm;
import top.shiro_demo.user.service.PermService;
import top.shiro_demo.user.service.UserPermService;
import top.shiro_demo.user.service.UserService;

import java.util.Set;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private UserPermService userPermService;
    @Autowired
    private PermService permService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        Integer userId = user.getId();
        UserPerm userPerm = userPermService.selectByUserId(userId);
        if (userPerm == null){
            return null;
        }
        Set<String> perms = permService.selectByPermIds(userPerm.getPermId().split(","));

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.selectByPhone(token.getUsername());
        if (user == null){
            throw new UnknownAccountException();
        }
        if (user.getStatus() == 0){
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
    }

    //加密
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        super.setCredentialsMatcher(matcher);
    }
}
