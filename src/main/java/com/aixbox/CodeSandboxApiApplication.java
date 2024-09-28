package com.aixbox;


import com.aixbox.rpcspringbootstarter.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRpc
@SpringBootApplication
public class CodeSandboxApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(CodeSandboxApiApplication.class, args);
    }

}
