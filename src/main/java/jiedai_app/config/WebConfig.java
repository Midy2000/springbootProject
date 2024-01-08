
package jiedai_app.config;

import jiedai_app.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor checkInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CorsMappings configured");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081")
                .allowedMethods("*","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkInterceptor).addPathPatterns("/**");
    }
}
