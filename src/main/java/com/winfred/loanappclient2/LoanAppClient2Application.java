package com.winfred.loanappclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanAppClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(LoanAppClient2Application.class, args);
    }

}
