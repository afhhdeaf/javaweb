package top.raven.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.raven.springboot.interceptor.CorsInterceptor;
import top.raven.springboot.interceptor.LoginInterceptor;
import top.raven.springboot.interceptor.NoMappingInterceptor;

@Configuration
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    @Bean
    NoMappingInterceptor getNoMappingInterceptor() {
        return new NoMappingInterceptor();
    }

    @Bean
    LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor getCorsRegistry() {
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域拦截器
        registry.addInterceptor(getCorsRegistry()).addPathPatterns("/**");
        //404拦截器
        registry.addInterceptor(getNoMappingInterceptor()).addPathPatterns("/**");
        //登录拦截器
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(3600);
    }
}
