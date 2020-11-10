package lk.ijse.dep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class,args);
    }
}
