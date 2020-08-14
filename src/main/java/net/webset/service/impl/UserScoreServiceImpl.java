package net.webset.service.impl;

import net.webset.entity.UserScore;
import net.webset.mapper.UserScoreMapper;
import net.webset.service.IUserScoreService;
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
public class UserScoreServiceImpl extends ServiceImpl<UserScoreMapper, UserScore> implements IUserScoreService {

}
