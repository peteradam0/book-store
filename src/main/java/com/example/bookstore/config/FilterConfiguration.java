package com.example.bookstore.config;

import com.example.bookstore.Filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class FilterConfiguration implements WebMvcConfigurer {
    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Value("#{'${list.endpoints}'.split(',')}")
    private List<String> endpointsList;

    @Bean
    public FilterRegistrationBean headerValidatorFilrter() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("authenticationFilter");
        registrationBean.setFilter(authenticationFilter);
        registrationBean.setUrlPatterns(endpointsList);
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
