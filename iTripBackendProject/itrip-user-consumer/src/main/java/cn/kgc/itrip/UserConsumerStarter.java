package cn.kgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>consumer 启动类</b>
 * @author Administrator
 * @version
 * @since
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class UserConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerStarter.class,args);
    }
}
