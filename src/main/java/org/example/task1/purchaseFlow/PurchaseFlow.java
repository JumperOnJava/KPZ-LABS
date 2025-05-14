package org.example.task1.purchaseFlow;

import org.example.task1.subscription.*;

import java.security.InvalidParameterException;

public abstract class PurchaseFlow {
    public abstract Subscription finishPurchase() throws InvalidParameterException;
}
