package ru.cleverec.entity;

import util.EntityFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    private final List<Request> requests = new ArrayList<>();
    private final List<Future<Response>> responses = new ArrayList<>();
    private final ExecutorService executor;
    private final EntityFactory factory = new EntityFactory();

    public Client(int requestsSize, int poolSize) {
        executor = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < requestsSize; i++) {
            requests.add(factory.createRequest());
        }
    }

    public List<Future<Response>> sendAllRequests(Server server) {
        requests.forEach(request -> responses.add(sendRequest(request, server)));
        executor.shutdown();
        return responses;
    }

    private Future<Response> sendRequest(Request request, Server server){
        return executor.submit(() -> server.processRequest(request));
    }

}
