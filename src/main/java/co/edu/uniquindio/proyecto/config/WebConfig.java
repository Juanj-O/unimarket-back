package co.edu.uniquindio.proyecto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://unimarket-back-production.up.railway.app", "http://unimarket-back-production.up.railway.app/api/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
