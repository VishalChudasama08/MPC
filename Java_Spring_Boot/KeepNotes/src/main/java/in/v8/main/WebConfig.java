package in.v8.main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "in.v8.main")
public class WebConfig implements WebMvcConfigurer {
	
	public WebConfig() {
        // Adjust Hibernate logging levels programmatically
        Logger.getLogger("org.hibernate").setLevel(Level.INFO); // Suppresses Hibernate DEBUG logs
        Logger.getLogger("org.hibernate.SQL").setLevel(Level.INFO); // Suppresses SQL logs
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Add the Jackson message converter for JSON
        converters.add(new MappingJackson2HttpMessageConverter());
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("in.v8.main.entities");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
	
	// Configure the view resolver for JSP
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // Path to your JSP files
        resolver.setSuffix(".jsp"); // JSP file extension
        resolver.setViewClass(JstlView.class); // Use JSTL view
        return resolver;
    }
}
