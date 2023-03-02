package ru.cleverec.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ServerTest {

    private final static int REQUEST_VALUE = 10;
    private final static int RESPONSE_VALUE = 190;
    private static Server server;
    private static Request request;
    private static Response response;

    @BeforeAll
    static void init(){
        server = new Server();
        request = new Request(REQUEST_VALUE);
        response = new Response();
        response.setValue(RESPONSE_VALUE);
    }

    @Test
    void checkProcessRequest(){
        assertThat(server.processRequest(request)).isEqualTo(response);
    }
}