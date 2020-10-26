package cn.kgc.itrip.base.pojo.vo;

import java.io.Serializable;

/**
 * <b>响应结果视图对象</b>
 * @param <E>
 * @author Administrator
 * @version
 * @since
 */
public class ResultVo<E> implements Serializable {
    private static final long serialVersionUID = -7739246007165938055L;

    private String success;                //判断系统是否出错，返回 true 或者 false；
    private String errorCode;              //自定义错误码
    private String msg;                     //返回的提示信息
    private E data;                         //返回数据

    public ResultVo () {}
    public ResultVo (boolean success) {
        this.success = Boolean.toString(success);
    }

    public ResultVo (boolean success, String msg) {
        this.success = Boolean.toString(success);
        this.msg = msg;
    }

    public ResultVo (boolean success, Integer errorCode, String msg, E data) {
        this.success = Boolean.toString(success);
        this.errorCode = Integer.toString(errorCode);
        this.msg = msg;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }


}
