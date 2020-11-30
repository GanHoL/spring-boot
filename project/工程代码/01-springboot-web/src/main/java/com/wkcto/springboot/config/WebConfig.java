package com.wkcto.springboot.config;

import com.wkcto.springboot.filter.HeFilter;
import com.wkcto.springboot.interceptor.LoginInterceptor;
import com.wkcto.springboot.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:WebConfig
 * <p>
 * Package:com.wkcto.springboot.config
 * Description:
 *
 * @Date:2018/8/7 11:07
 * @Author:GanHoL
 */
@Configuration // 等价于一个 spring的xml配置文件，比如 applicationContext.xml
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截器要拦截的路径
        String[] pathPatterns = {
                "/**"
        };

        //拦截器不拦截的路径
        String[] excludePathPatterns = {
                "/boot/hello",
                "/boot/jsp"
        };

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);

        //如果项目中有多个拦截器，那么把这行代码多写几份即可
        //registry.addInterceptor(new AuthInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);
    }

    /**
     * 注册一个servlet
     *
     * @Bean 注解等价于 spring 的xml中配置一个:
     *
     * <bean id="heServletRegistrationBean" class="xxx.xxx.xxx..ServletRegistrationBean">
     *
     * </bean>
     *
     * 方法名等于id
     * 方法返回类型等于class
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/heServlet");
        return registration;
    }

    /**
     * 注册一个filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean heFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new HeFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 字符编码过滤器
     *
     * @return
     */
    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //创建spring-web提供的一个字符编码过滤器类
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);//强制对请求编码
        characterEncodingFilter.setEncoding("UTF-8");//编码类型

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }*/
}
