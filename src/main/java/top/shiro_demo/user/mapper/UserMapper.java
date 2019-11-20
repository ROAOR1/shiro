package top.shiro_demo.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.shiro_demo.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wwh
 * @since 2019-10-30
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByPhone(String phone);
}
