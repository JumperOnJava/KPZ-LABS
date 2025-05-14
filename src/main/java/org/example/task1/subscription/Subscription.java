package org.example.task1.subscription;

import java.util.List;

public interface Subscription {
    float getPrice();
    int getMinimalMonthsDuration();
    List<String> getChannels();
    boolean hasAds();
    String getName();
}
