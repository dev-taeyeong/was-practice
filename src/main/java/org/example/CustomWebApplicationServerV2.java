package org.example;

import org.example.calculator.ClientRequestHandler;
import org.example.calculator.QueryStrings;
import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServerV2 {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServerV2.class);

    public CustomWebApplicationServerV2(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] stared {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
