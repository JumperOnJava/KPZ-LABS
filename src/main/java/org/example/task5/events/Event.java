package org.example.task5.events;

import java.util.ArrayList;
import java.util.List;

public class Event<T> implements Publisher<T> {
    private final List<Subscriber<T>> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber<T> subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber<T> subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void publish(T t) {
        this.subscribers.forEach(s -> s.run(t));
    }
}
