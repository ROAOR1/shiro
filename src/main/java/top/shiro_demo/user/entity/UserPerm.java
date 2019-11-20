package top.shiro_demo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wwh
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserPerm implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    private Integer userId;

    private String permId;


}
