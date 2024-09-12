package io.foldright.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import io.foldright.cffu.CompletableFutureUtils;


public class TimeoutBugDemo {

    public static void main(String[] args) {
        new CompletableFuture<Integer>().orTimeout(1, TimeUnit.SECONDS)
                .handle((v,ex)->{
                    System.out.printf("%n",ex);
                    System.out.println(Thread.currentThread().getName());
                    ex.printStackTrace();
                    return -1;
                }).join();
        System.out.println("Done");
        CompletableFutureUtils.cffuOrTimeout(new CompletableFuture<>(),1, TimeUnit.SECONDS).handle((v,ex)->{
            System.out.printf("%n",ex);
            System.out.println(Thread.currentThread().getName());
            ex.printStackTrace();
            return -1;
        }).join();
    }

}
