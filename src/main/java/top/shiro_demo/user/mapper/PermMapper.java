package top.shiro_demo.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import top.shiro_demo.user.entity.Perm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wwh
 * @since 2019-10-30
 */
public interface PermMapper extends BaseMapper<Perm> {

    Set<String> selectByPermIds(String[] perms);
}
