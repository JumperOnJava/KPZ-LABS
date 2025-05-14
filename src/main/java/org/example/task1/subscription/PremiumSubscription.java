package org.example.task1.subscription;

import org.example.task1.Channels;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PremiumSubscription implements Subscription {
    @Override
    public float getPrice() {
        return 20;
    }

    @Override
    public int getMinimalMonthsDuration() {
        return 12;
    }

    @Override
    public List<String> getChannels() {
        return Stream.of(Channels.MOVIES_CHANNELS, Channels.NEWS_CHANNELS, Channels.NATURE_CHANNELS, Channels.SPORTS_CHANNELS, Channels.HEALTH_CHANNELS).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public boolean hasAds() {
        return false;
    }

    @Override
    public String getName() {
        return "Premium";
    }
}
