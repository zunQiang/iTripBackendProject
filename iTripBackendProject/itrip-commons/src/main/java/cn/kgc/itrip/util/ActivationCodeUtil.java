package cn.kgc.itrip.util;

import java.util.Random;

/**
 * <b>激活码生成工具类</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public class ActivationCodeUtil {
    public static String generate() {
        Random random = new Random();
        // 使用 springBuffer 存储激活码信息
        StringBuffer sb = new StringBuffer();
        while (sb.length() != 6) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
