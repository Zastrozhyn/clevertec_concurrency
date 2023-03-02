package ru.cleverec.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientServerTest {

    private final static int REQUESTS_SIZE = 5;
    private final static int POOL_SIZE = 3;
    private static Client client;
    private static Server server;

    @BeforeAll
    static void init(){
        client = new Client(REQUESTS_SIZE, POOL_SIZE);
        server = new Server();
    }

    @Test
    void checkSendAllRequests(){
        assertThat(client.sendAllRequests(server)).hasSize(REQUESTS_SIZE);
    }
}