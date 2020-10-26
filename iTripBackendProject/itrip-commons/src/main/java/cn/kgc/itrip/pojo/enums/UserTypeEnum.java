package cn.kgc.itrip.pojo.enums;

/**
 * <b>用户注册类型枚举类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public enum UserTypeEnum {
    USER_TYPE_SELF(0,"自注册用户"),
    USER_TYPE_WECHAT(1,"微信登录"),
    USER_TYPE_QQ(2,"QQ"),
    USER_TYPR_WEIBO(3,"微博登录")
    ;
    private Integer code;
    private String remark;

    private UserTypeEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
