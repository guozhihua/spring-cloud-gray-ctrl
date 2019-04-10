package serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
//注册服务于eureka
@EnableDiscoveryClient
//熔断器
//开启feign 调用
@EnableFeignClients(basePackages = {"api"})

/**
 * 直接继承springbootServletInitializer 可以实现tomcat 启动
 */
public class ServiceAApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServiceAApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

}
