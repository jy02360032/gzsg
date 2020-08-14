package net.webset.service.impl;

import net.webset.entity.Menu;
import net.webset.mapper.MenuMapper;
import net.webset.service.IMenuService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getListByHref(){
		QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("href", "authNode");
        List<Menu> menuList = menuMapper.selectList(queryWrapper);
		return menuList;
	}

}
