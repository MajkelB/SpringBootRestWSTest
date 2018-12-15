package mb.test.restSpringBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
//@ComponentScan
public class RestSpringBootTestApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestSpringBootTestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestSpringBootTestApplication.class, args);
    }
}