package ericspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServceAutoConfiguration {
    @Bean
    @Conditional(TomcatCondition.class)
    public WebServer tomcatWebserver(){
        return new TomcatWebserver();
    }
    @Bean
    @Conditional(JettyCondition.class)
    public WebServer jettyWebserver(){
        return new JettyWebserver();
    }
}
