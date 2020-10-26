package cn.kgc.itrip.pojo.enums;

/**
 * <b>用户激活状态枚举类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public enum ActivatedEnum {
    ACTIVATED_TRUE(1,"已激活"),
    ACTIVATED_FALSE(0,"未激活")
    ;
    private Integer code;
    private String remark;

    ActivatedEnum(Integer code, String remark) {
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
