package com.epam.adok;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<Integer> callableFuture = service.submit(() -> {
            Thread.sleep(1000 * 2);
            System.out.println("Callable completed");
            return 12;
        });

        Integer resutlFromThread = callableFuture.get();
        System.out.println("After Callable creation:"  + resutlFromThread);


        Future runnableFuture = service.submit(() -> {
            try {
                Thread.sleep(1000 * 2);
                System.out.println("Runnable completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Object o = runnableFuture.get();
        System.out.println("After Runnable creation:"  + o);

    }
}
