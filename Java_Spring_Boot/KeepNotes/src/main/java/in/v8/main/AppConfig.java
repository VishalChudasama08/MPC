package in.v8.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "in.v8.main")
public class AppConfig {

//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("in.v8.main.entities");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database");
//        dataSource.setUsername("your_username");
//        dataSource.setPassword("your_password");
//        return dataSource;
//    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
}
