package cn.kgc.itrip.dao;

import cn.kgc.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户模块数据持久层接口</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface UserDao {
    /**
     * <b>校验用户名是否被使用</b>
     * @param query
     * @return
     * @throws Exception
     */
    List<User> findListByQuery(User query) throws Exception;

    /**
     * <b>保存用户信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    Integer saveUser(User entity) throws Exception;

    /**
     * <b>更新用户信息</b>
     * @param user
     * @return
     * @throws Exception
     */
    Integer update(User user) throws Exception;
}
