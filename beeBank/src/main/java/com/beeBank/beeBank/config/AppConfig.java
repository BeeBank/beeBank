package com.beeBank.beeBank.config;

// import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.beeBank.beeBank.interceptors.AppInterceptor;

@Configuration
@ComponentScan(basePackages = {"src/main/java/com/beeBank/beeBank"})
public class AppConfig extends WebMvcConfigurationSupport{
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
       registry.addResourceHandler("css/**","images/**", "js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/images/","classpath:/static/js/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);

        return jspViewResolver;
    }
    // End of View Resolver.

    @Override
    protected void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(new AppInterceptor()).addPathPatterns("/app/*");    
    }
    //End of interceptor registry 
}
