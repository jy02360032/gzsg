package net.webset.mapper;

import net.webset.entity.UserRole;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

	public List<UserRole> findByUserID(Integer id);
}
