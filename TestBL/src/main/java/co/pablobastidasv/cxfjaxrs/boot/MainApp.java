package co.pablobastidasv.cxfjaxrs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pbastidas
 */
@SpringBootApplication(scanBasePackages = {"co.pablobastidasv.cxfjaxrs"})
public class MainApp {

    public static  void main(String... args){
        SpringApplication.run(MainApp.class, args);
    }

}
