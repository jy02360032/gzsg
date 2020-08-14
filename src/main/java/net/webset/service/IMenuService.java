package net.webset.service;

import net.webset.entity.Menu;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
public interface IMenuService extends IService<Menu> {
	
	List<Menu> getListByHref();

}
