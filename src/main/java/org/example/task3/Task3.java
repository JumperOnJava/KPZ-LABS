package org.example.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    static volatile AtomicInteger counter = new AtomicInteger(0);
    public static void Main() {
        Runnable task = () -> {
            Authenticator auth = Authenticator.getInstance();
            System.out.println("Instance hash: " + auth.hashCode());
            auth.login("admin", "12345");
            counter.incrementAndGet();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        //await for finish
        while (counter.get() != 3);
    }
}
