package com.othmane;


import com.othmane.services.MoroccanTeaService;
import com.othmane.services.TeaService;
import com.othmane.services.Temperature;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
public class TeaAutoConfigurationTest {

    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TeaAutoConfiguration.class));

    @Test
    public void given_emptyconfiguration_autoconf_should_popup() {
        runner.withUserConfiguration(EmptyConfiguration.class).run(context -> {
            Assertions.assertThat(context).hasBean("teaService");

        });

    }

    @Test
    public void given_userBean_autoconf_should_backoff() {
        runner.withUserConfiguration(UserConfiguration.class).run(context -> {

            Assertions.assertThat(context).hasSingleBean(TeaService.class);
            TeaService teaService=context.getBean(TeaService.class);
            System.out.println(teaService.drink());

        });

    }

    @Test
    public void given_usereProperty_autoconf_should_useit() {
        runner.withUserConfiguration(EmptyConfiguration.class).withPropertyValues("tea.api.type=Rose").run(context -> {

            Assertions.assertThat(context).hasSingleBean(TeaService.class);
            TeaService teaService=context.getBean(TeaService.class);
            System.out.println(teaService.drink());

        });

    }

    @Configuration
    static class EmptyConfiguration{

    }

    @Configuration
    static class UserConfiguration{

        @Bean
        public TeaService teaServiceUser(){
            return new MoroccanTeaService("Black", Temperature.HOT);
        }
    }

}
