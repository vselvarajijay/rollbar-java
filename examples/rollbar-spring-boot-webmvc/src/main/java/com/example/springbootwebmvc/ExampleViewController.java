package com.example.springbootwebmvc;

import com.rollbar.notifier.Rollbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleViewController {

  @Autowired
  private Rollbar rollbar;

  /**
   * Testing an uncaught exception - The register Rollbar bean will pick this up.
   */
  @RequestMapping("/")
  public void exceptionTest() {

    // This exception will be passed now via the exception resolver
    this.divideTwoNumbers(1,0);

  }

  private void divideTwoNumbers(int a, int b) {
    int x = a / b;
  }

  /**
   * Testing a handled exception. Rollbar will pick up uncaught automatically offering you
   * the option to send a custom log.
   */
  @RequestMapping("/handledExceptionTest")
  public void handledExceptionTest() {

    try {

      int x = 1 / 0;

    } catch (Exception e) {

      rollbar.log("log some error to Rollbar");
      throw e; // continue to raise it and Rollbar will send the full payload

    }

  }

  /**
   * This is an example of how to access the Rollbar object and send an error.
   */
  @RequestMapping("/rollbarTest")
  public void rollbarTest() {

    rollbar.error("Error");

  }
}