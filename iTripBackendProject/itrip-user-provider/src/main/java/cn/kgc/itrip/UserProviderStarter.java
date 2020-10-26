package cn.kgc.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>Provider 启动类</b>
 * @author Administrator
 * @version
 * @since
 */
@MapperScan("cn.kgc.itrip.dao")
@EnableEurekaClient
@SpringBootApplication
public class UserProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderStarter.class,args);
    }
}
