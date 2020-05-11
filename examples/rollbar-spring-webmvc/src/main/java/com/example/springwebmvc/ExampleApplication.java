package com.example.springwebmvc;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

import com.rollbar.notifier.Rollbar;
import com.rollbar.spring.webmvc.RollbarExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;



@SpringBootApplication
@Configuration()
@ComponentScan()
public class ExampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }

  /**
   * Handles all exceptions with Rollbar's Exception Resolver.
   */
  @Bean
  public HandlerExceptionResolver rollbarExceptionResolver() {
    return new RollbarExceptionResolver(
      Rollbar.init(withAccessToken("<ENTER POST_SERVER_ITEM ACCESS TOKEN>")
              .environment("development")
              .build()));
  }

}
