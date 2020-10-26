package cn.kgc.itrip.transport.impl.user;


import cn.kgc.itrip.pojo.entity.User;
import cn.kgc.itrip.service.UserService;
import cn.kgc.itrip.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>爱旅行-用户模块传输层接口实现类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@RestController("userTransport")
@RequestMapping("/user/transport")
public class UserTransportImpl implements UserTransport {
    @Autowired
    private UserService userService;

    /**
     * <b>校验用户名是否被使用</b>
     * @param userCode
     * @return
     * @throws Exception
     */
    @PostMapping("/ckusr")
    @Override
    public boolean queryUserCodeIsCanUsed(@RequestParam String userCode) throws Exception {
        return userService.queryUserCodeIsCanUsed(userCode);
    }

    /**
     * <b>保存用户信息</b>
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/doregister")
    @Override
    public boolean saveUser(User user) throws Exception {
        return userService.saveUser(user);
    }
}
