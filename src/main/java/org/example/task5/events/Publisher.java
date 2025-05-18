package org.example.task5.events;

public interface Publisher<T>{
    void subscribe(Subscriber<T> subscriber);
    void unsubscribe(Subscriber<T> subscriber);
    void publish(T t);
}
