package cn.kgc.itrip.controller;

import cn.kgc.itrip.base.controller.BaseController;
import cn.kgc.itrip.base.pojo.vo.ResultVo;
import cn.kgc.itrip.pojo.entity.User;
import cn.kgc.itrip.pojo.enums.ActivatedEnum;
import cn.kgc.itrip.pojo.enums.UserTypeEnum;
import cn.kgc.itrip.pojo.vo.UserVO;
import cn.kgc.itrip.transport.user.UserTransport;
import cn.kgc.itrip.util.MD5Util;
import cn.kgc.itrip.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * <b>爱旅行-用户认证模块控制器</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController extends BaseController {
    @Autowired
    private UserTransport userTransport;
    /**
     * <b>验证是用户名是否被占用</b>
     * @param name
     * @return
     * @throws Exception
     */

    @GetMapping("/ckusr")
    public ResultVo checkName(String name) throws Exception {
        // 校验用户是否存在，区分为邮箱和手机号用户名
        boolean isCanUsed = userTransport.queryUserCodeIsCanUsed(name);
        if (isCanUsed) {
            //得到的结果为true，该用户名可以使用
            return new ResultVo(true,"该用户名已被使用！");
        }
        return new ResultVo(true,null,"该用户名可以使用！",null);
    }

    /**
     * <b>使用邮箱邮箱注册</b>
     * @param userVO
     * @return
     * @throws Exception
     */
    @PostMapping("/doregister")
    public ResultVo registerUserByEmail(@RequestBody UserVO userVO) throws Exception {
        // 校验邮箱密码是否有效
        if (ValidateUtil.checkEmailFormat(userVO.getUserCode())
                && ValidateUtil.checkPassword(userVO.getUserPassword())) {
            // 校验邮箱是否重复
            if (userTransport.queryUserCodeIsCanUsed(userVO.getUserCode())) {
                // 保存用户
                // 根据情况需将 UserVO 转成 User
                User user = new User();
                user.setUserCode(userVO.getUserCode());
                user.setUserPassword(userVO.getUserPassword());
                user.setUserName(userVO.getUserName());
                user.setUserType(UserTypeEnum.USER_TYPE_SELF.getCode());
                user.setCreationDate(new Date());
                user.setModifyDate(new Date());
                user.setActivated(ActivatedEnum.ACTIVATED_FALSE.getCode());

                boolean saveFlag = userTransport.saveUser(user);
                if (saveFlag) {
                    return new ResultVo(true,"保存成功！");
                } else {
                    return new ResultVo(false,"保存失败！");
                }
            } else {
                return new ResultVo(false,"用户名已被占用！");
            }
        } else {
            return new ResultVo(false,"请填写正确的邮箱和登录密码！");
        }
    }

    /**
     * <b>使用手机注册</b>
     * @param userVO
     * @return
     * @throws Exception
     */
    @PostMapping("/registerbyphone")
    public ResultVo registerUserByCellhone(@RequestBody UserVO userVO) throws Exception {
        // 校验手机号码是否有效
        if (ValidateUtil.checkCellphoneFormat(userVO.getUserCode())
                && ValidateUtil.checkPassword(userVO.getUserPassword())) {
            // 校验手机号是否唯一
            if (userTransport.queryUserCodeIsCanUsed(userVO.getUserCode())) {
                // 保存用户
                // 根据情况需将 UserVO 转成 User
                User user = new User();
                user.setUserCode(userVO.getUserCode());
                user.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
                user.setUserName(userVO.getUserName());
                user.setUserType(UserTypeEnum.USER_TYPE_SELF.getCode());
                user.setCreationDate(new Date());
                user.setModifyDate(new Date());
                user.setActivated(ActivatedEnum.ACTIVATED_FALSE.getCode());

                boolean saveFlag = userTransport.saveUser(user);
                if (saveFlag) {
                    return new ResultVo(true,"保存成功！");
                } else {
                    return new ResultVo(false,"保存失败！");
                }
            } else {
                return new ResultVo(false,"用户名已被占用");
            }
        } else {
            return new ResultVo(false,"请填写正确的邮箱和登录密码！");
        }
    }
}
