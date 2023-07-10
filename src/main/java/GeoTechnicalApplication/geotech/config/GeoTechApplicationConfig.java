package GeoTechnicalApplication.geotech.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Optional;

import static GeoTechnicalApplication.geotech.config.GeoTechApplicationConfig.AUDIT_PROVIDER;

@Configuration
@Log4j2
@EnableJpaAuditing(auditorAwareRef = AUDIT_PROVIDER)
@EnableWebMvc
@EnableJpaRepositories
public class GeoTechApplicationConfig  implements WebMvcConfigurer {

    public static final String AUDIT_PROVIDER = "auditProvider";

    @Bean
    @ConfigurationProperties(prefix = "geo.application")
    public GeoTechApplicationProperties createGeoTechApplicationProperties() {
        return new GeoTechApplicationProperties();
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean(AUDIT_PROVIDER)
   public  AuditorAware<String> auditorAware()
    {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return Optional.of("User");
            }
        };
    }


}
