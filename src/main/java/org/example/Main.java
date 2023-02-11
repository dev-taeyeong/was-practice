package org.example;

import java.io.IOException;

// GET /calculate?operand1=11&operator=*&operand2=55
public class Main {
    public static void main(String[] args) throws IOException {
        // new CustomWebApplicationServer(8080).start(); // v1
        // new CustomWebApplicationServerV2(8080).start(); // v2
        new CustomWebApplicationServerV3(8080).start();
    }
}