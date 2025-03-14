package org.algorithms.onecontact;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CeramicStore {
    public static void runAndWait(List<Runnable> runnables) {
        List<CompletableFuture<Void>> cfs = runnables.stream().map(CompletableFuture::runAsync).toList();
        cfs.forEach(c -> {
            try {
                c.get();
            } catch (InterruptedException | ExecutionException ie) {
                ie.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(800);
                System.out.println("Slow function");
            } catch(Exception e) {}
        }, () -> {
            try {
                Thread.sleep(100);
                System.out.println("Fast function");
            } catch(Exception e) {}
        });

        // Expected output:
        // Fast function
        // Slow function
        // Returned from the method!
        runAndWait(runnables);
        System.out.println("Returned from the method!");
    }
}