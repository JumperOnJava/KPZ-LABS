package org.example.task5.events;

public interface Subscriber<T>{
    void run(T t);
}
