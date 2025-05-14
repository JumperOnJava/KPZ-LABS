package org.example.task1.subscription;

import org.example.task1.Channels;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentSubscription implements Subscription {
    @Override
    public float getPrice() {
        return 6;
    }

    @Override
    public int getMinimalMonthsDuration() {
        return 12;
    }

    @Override
    public List<String> getChannels() {
        //no movies for you go study nature or health
        return Stream.of(Channels.HEALTH_CHANNELS, Channels.NEWS_CHANNELS, Channels.NATURE_CHANNELS).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public boolean hasAds() {
        return true;
    }

    @Override
    public String getName() {
        return "Student";
    }
}
