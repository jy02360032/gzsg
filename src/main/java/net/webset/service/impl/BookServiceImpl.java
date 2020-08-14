package net.webset.service.impl;

import net.webset.entity.Book;
import net.webset.mapper.BookMapper;
import net.webset.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
