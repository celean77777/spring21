package com.celean.spring21.config;

import com.celean.spring21.models.ServicesLog;
import com.celean.spring21.models.ServicesLogItem;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;


@Configuration
@ComponentScan("com.celean.spring21")
public class LogConfig {

    @Bean
    public ServicesLog getServicesLog() {
        ServicesLog servicesLog = new ServicesLog();
        return servicesLog;
    }
}
