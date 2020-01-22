package com.alok.mytutorwebapp.Configuration;

import com.alok.mytutorwebapp.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.validation.OverridesAttribute;

@Configuration
@PropertySource("classpath:demodatasource.properties")
public class PropertyConfiguration {

        @Value("${alok.username}")
        String username;

        @Value("${alok.password}")
        String password;

        @Value("${alok.url}")
        String url;

        @Bean
        public FakeDataSource fakeDataSource(){
            FakeDataSource fakeDataSource = new FakeDataSource();
            fakeDataSource.setUsername(username);
            fakeDataSource.setPassword(password);
            fakeDataSource.setUrl(url);

            return fakeDataSource;
        }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
