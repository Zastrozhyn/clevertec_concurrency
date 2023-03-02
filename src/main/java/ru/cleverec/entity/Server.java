package ru.cleverec.entity;

import util.EntityFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    private final Map<String, Integer> processingInfo = new HashMap<>();
    private final EntityFactory factory = new EntityFactory();

    private final Lock lock = new ReentrantLock();

    public Response processRequest(Request request) {
        ProcessDelay delay = factory.createProcessDelay();
        int delayTime = delay.delayTime();
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Response response = new Response();
        int value = request.value();
        response.setValue(200 - value);

        try {
            lock.lock();
            if(processingInfo.containsKey(Thread.currentThread().getName())){
                delayTime = processingInfo.get(Thread.currentThread().getName()) + delayTime;
                processingInfo.put(Thread.currentThread().getName(), delayTime);
            } else {
                processingInfo.put(Thread.currentThread().getName(), delayTime);
            }

        } finally {
            lock.unlock();
        }
        displayInfo();

        return response;
    }

    public void displayInfo(){
        for (String key : processingInfo.keySet()){
            System.out.println(key + " delay time: " + processingInfo.get(key));
        }
        System.out.println("__________________________");
    }
}
