package cn.kgc.itrip.service.impl;

import cn.kgc.itrip.dao.UserDao;
import cn.kgc.itrip.pojo.entity.User;
import cn.kgc.itrip.pojo.enums.UserTypeEnum;
import cn.kgc.itrip.service.UserService;
import cn.kgc.itrip.util.ActivationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <b>爱旅行-用户模块业务层接口实现类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * <b>校验用户名是否被使用</b>
     * @param userCode
     * @return
     * @throws Exception
     */
    @Override
    public boolean queryUserCodeIsCanUsed(String userCode) throws Exception {
        // 封装查询对象
        User query = new User();
        query.setUserCode(userCode);
        // 进行查询
        List<User> list = userDao.findListByQuery(query);
        // 判断查询结果时否为空
        if (list != null && list.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * <b>保存用户信息</b>
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveUser(User user) throws Exception {
        // 保存用户信息
        Integer count = userDao.saveUser(user);
        if (count > 0) {
            if (user.getUserType().equals(UserTypeEnum.USER_TYPE_SELF.getCode())) {
                // 将主键id 赋给 flatID
                user = userDao.findListByQuery(user).get(0);
                user.setFlatID(user.getId());
                // 修改用户信息
                userDao.update(user);
            }
            // 生成随机激活码
            String activationCode = ActivationCodeUtil.generate();
            // 将激活码存储至 reids 中,userCode 为 key,激活码为 value
            redisTemplate.opsForValue().set(user.getUserCode(), activationCode);
            // 设定激活码过期时间
            redisTemplate.expire(user.getUserCode(), 5, TimeUnit.MINUTES);
            System.out.println(activationCode);
            // 将激活码发送到邮箱
            return true;
        }
        return false;
    }
}
