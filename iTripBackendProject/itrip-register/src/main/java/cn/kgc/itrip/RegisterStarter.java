package cn.kgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>注册中心启动类</b>
 * @author  admin
 * @version 1.0
 * @since   1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterStarter {
    public static void main(String[] args) {
        SpringApplication.run(RegisterStarter.class,args);
    }
}
