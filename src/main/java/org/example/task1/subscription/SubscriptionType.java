package org.example.task1.subscription;

import java.util.function.Function;
import java.util.function.Supplier;

public enum SubscriptionType {
    DOMESTIC(DomesticSubscription::new),
    PREMIUM(PremiumSubscription::new),
    STUDENT(StudentSubscription::new);

    private final Supplier<Subscription> subscriptionSupplier;
    public Subscription createSubscription() {return subscriptionSupplier.get();}

    SubscriptionType(Supplier<Subscription> supplier) {
        this.subscriptionSupplier = supplier;
    }
}
