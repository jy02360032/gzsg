package net.webset.mapper;

import net.webset.entity.Book;

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
public interface BookMapper extends BaseMapper<Book> {

}
