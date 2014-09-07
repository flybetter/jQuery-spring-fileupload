package sk.bsmk.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bsmk on 9/7/14.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application {

  public static void main(String ... args) {
    SpringApplication.run(Application.class, args);
  }

}
