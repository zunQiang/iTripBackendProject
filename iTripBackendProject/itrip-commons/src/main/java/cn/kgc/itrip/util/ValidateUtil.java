package cn.kgc.itrip.util;

/**
 * <b>用户信息校验工具类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public class ValidateUtil {
    private static String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    private static String cellphoneRegex = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    /**
     * <b>校验 email 是否正确</b>
     * @param email
     * @return
     */
    public static boolean checkEmailFormat(String email) {
        if (email != null && email.matches(emailRegex)) {
            return true;
        }
        return false;
    }

    /**
     * <b>校验登录密码是否正确</b>
     * @param password
     * @return
     */
    public static boolean checkPassword (String password) {
        if (password != null && !"".equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * <b>校验手机号码是否正确</b>
     * @param cellphone
     * @return
     */
    public static boolean checkCellphoneFormat(String cellphone) {
        if (cellphone != null && cellphone.matches(cellphoneRegex)) {
            return true;
        }
        return false;
    }
}
