package cn.kgc.itrip.transport.user;

import cn.kgc.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>爱旅行-用户模块传输层接口</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@FeignClient("itrip-user-provider")
@RequestMapping("/user/transport")
public interface UserTransport {
    /**
     * <b>校验用户名是否被使用</b>
     * @param userCode
     * @return
     * @throws Exception
     */
    @PostMapping("/ckusr")
    boolean queryUserCodeIsCanUsed(@RequestParam String userCode) throws Exception;

    /**
     * <b>保存用户信息</b>
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/doregister")
    boolean saveUser(@RequestBody User user) throws Exception;
}
