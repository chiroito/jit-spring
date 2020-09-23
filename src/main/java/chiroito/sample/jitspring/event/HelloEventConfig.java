package chiroito.sample.jitspring.event;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloEventConfig {

    @Bean
    public FilterRegistrationBean myWebMvcFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new HelloEventFilter());
        bean.addUrlPatterns("/hello");
        bean.setOrder(1);
        return bean;
    }
}
