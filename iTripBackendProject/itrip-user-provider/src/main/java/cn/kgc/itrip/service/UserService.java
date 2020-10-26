package cn.kgc.itrip.service;

import cn.kgc.itrip.pojo.entity.User;

/**
 * <b>爱旅行-用户模块业务层接口</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public interface UserService {
    /**
     * <b>校验用户名是否被使用</b>
     * @param userCode
     * @return
     * @throws Exception
     */
    boolean queryUserCodeIsCanUsed(String userCode) throws Exception;

    /**
     * <b>保存用户信息</b>
     * @param user
     * @return
     * @throws Exception
     */
    boolean saveUser(User user) throws Exception;
}
