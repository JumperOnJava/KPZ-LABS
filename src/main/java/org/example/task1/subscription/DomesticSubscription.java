package org.example.task1.subscription;

import org.example.task1.Channels;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomesticSubscription implements Subscription {
    @Override
    public float getPrice() {
        return 10;
    }

    @Override
    public int getMinimalMonthsDuration() {
        return 1;
    }

    @Override
    public List<String> getChannels() {
        return Stream.of(Channels.MOVIES_CHANNELS, Channels.NEWS_CHANNELS, Channels.NATURE_CHANNELS).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public boolean hasAds() {
        return true;
    }

    @Override
    public String getName() {
        return "Domestic";
    }
}
