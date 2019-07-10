package com.othmane;


import com.othmane.services.MoroccanTeaService;
import com.othmane.services.TeaService;
import com.othmane.services.Temperature;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TeaService.class)
@EnableConfigurationProperties(TeaProperties.class)
public class TeaAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TeaService teaService(TeaProperties properties){
        return new MoroccanTeaService(properties.getType(), properties.getTemperature());
    }
}
