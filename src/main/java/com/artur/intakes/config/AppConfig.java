//package com.artur.intakes.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class AppConfig {
//
//    @Autowired
//    private Environment environment;
//
//
//    @Bean
//    public DataSource getDataSource() {
////        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("org.h2.Driver");
////        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
////        dataSourceBuilder.username("sa");
////        dataSourceBuilder.password("");
////        return dataSourceBuilder.build();
//
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.driverClassName(environment.getProperty("jdbc.drive-class-name"));
////        dataSourceBuilder.driverClassName(environment.getProperty("jdbc.driverClassName"));
////        dataSourceBuilder.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_intakes_diary");
////        dataSourceBuilder.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/test_db_intakes_diary");
//        dataSourceBuilder.driverClassName(environment.getProperty("jdbc.url"));
//        dataSourceBuilder.username(environment.getProperty("jdbc.username"));
//        dataSourceBuilder.password(environment.getProperty("jdbc.password"));
//        return dataSourceBuilder.build();
//    }
//
////    @Bean
////    public PasswordEncoder encoder() {
////        return new BCryptPasswordEncoder();
////    }
//}
