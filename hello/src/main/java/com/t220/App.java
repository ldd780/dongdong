package com.t220;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;



/**
 * Hello world!
 *
 */
//只扫描同级包下的
@SpringBootApplication//@ComponentScan,@EnableAutoConfiguration,@Configuration
//@EnableAutoConfiguration
@MapperScan(value= {"com.t220"})
//扫描注解包
//@ComponentScan(basePackages={"com.t220.controler","com.t220.service"})
//扫描jpa数据层的范围
//@EnableJpaRepositories()
//扫描实体
//@EntityScan()
@EnableScheduling//启动定时调度任务
@EnableConfigurationProperties
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
