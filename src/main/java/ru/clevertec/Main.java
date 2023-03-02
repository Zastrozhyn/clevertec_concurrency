package ru.clevertec;

import ru.cleverec.entity.Client;
import ru.cleverec.entity.Response;
import ru.cleverec.entity.Server;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(5, 3);
        List<Future<Response>> futures = client.sendAllRequests(server);

        futures.stream().mapToInt(response -> {
            try {
                return response.get().getValue();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);
    }
}
