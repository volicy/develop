package com.test.springboot.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.test.springboot.config.dynamicDataSource.DynamicDataSourceRegister;

/**
 * 
  @SpringBootApplication 相当于@Configuration,@EnableAutoConfiguration,@ComponentScan
 */
@SpringBootApplication(scanBasePackages = {"com.test.springboot"}, exclude = {})
//扫描工程中的Servlet、Filter、Listener
@ServletComponentScan(basePackages = {"com.test.springboot.config"})
//mybatis框架中的dao扫描
@MapperScan("com.test.springboot.mapper")
//注册动�?�多数据�?
@Import({DynamicDataSourceRegister.class})
//启注解事务管理，等同于xml配置方式�? <tx:annotation-driven />
@EnableTransactionManagement
/**
 * 
 * @Description SpringBootServletInitializer继承它的目的是为了打war

 */
public class SpringBootTest extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest.class, args);
    }
    
    /** 
     * @Description 这里是�?�过代码的形式注册一个Servlet，这种形式不�?要@ServletComponentScan注解 
     * @param @return 参数 
     * @return ServletRegistrationBean 返回类型  
     * @throws 
     */
    /*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new JackServlet(), "/jack/*");
    }*/
    
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
    
}
