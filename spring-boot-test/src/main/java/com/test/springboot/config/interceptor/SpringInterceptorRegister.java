package com.test.springboot.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
public class SpringInterceptorRegister extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SpringInterceptorRegister.class);
    
    /* 
     * 添加spring中的拦截�?
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JackInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new JeffInterceptor()).excludePathPatterns("/user/**");
        super.addInterceptors(registry);
    }
    
    /* 
     * 注册静�?�文件的自定义映射路�?
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ///image/**  这个是url请求路径
        //classpath:/image/ 去这个路径下寻找静�?�文�?
        registry.addResourceHandler("/image/**")
                .addResourceLocations("classpath:/image/");
        registry.addResourceHandler("/picture/**")
                .addResourceLocations("file:D:/picture/");
        super.addResourceHandlers(registry);
    }
    
    /** 
     * @Description 注册分页插件 
     * @param @return 参数 
     * @return PageHelper 返回类型  
     * @throws 
     */
    //    @Bean
    //    public PageHelper pageHelper() {
    //        logger.info("注册MyBatis分页插件PageHelper");
    //        PageHelper pageHelper = new PageHelper();
    //        Properties p = new Properties();
    //        p.setProperty("offsetAsPageNum", "true");
    //        p.setProperty("rowBoundsWithCount", "true");
    //        p.setProperty("reasonable", "true");
    //        pageHelper.setProperties(p);
    //        return pageHelper;
    //    }
}
