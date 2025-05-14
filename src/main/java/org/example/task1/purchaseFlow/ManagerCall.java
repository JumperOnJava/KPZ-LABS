package org.example.task1.purchaseFlow;

import org.example.task1.Task1;
import org.example.task1.subscription.Subscription;
import org.example.task1.subscription.SubscriptionType;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class ManagerCall extends PurchaseFlow {

    public ManagerCall() {
    }

    List<String> messages = new ArrayList<>();

    public void sayInCall(String message) {
        messages.add(message);
    }

    @Override
    public Subscription finishPurchase() {
        SubscriptionType desiredSubscription = null;
        boolean studentSubscriptionAvailable = false;
        for (String message : messages) {
            if (message.contains(Task1.STUDENT_DOCUMENT.document_id)) {
                studentSubscriptionAvailable = true;
            }
            for(var type : SubscriptionType.values()) {
                if (message.toLowerCase().contains(type.toString().toLowerCase())) {
                    desiredSubscription = SubscriptionType.valueOf(type.name());
                }
            }
        }
        if(desiredSubscription == null){
            throw new InvalidParameterException("Subscription is not specified");
        }
        if(desiredSubscription == SubscriptionType.STUDENT && !studentSubscriptionAvailable){
            throw new InvalidParameterException("Student subscription requires student document confirmation");
        }
        return desiredSubscription.createSubscription();
    }


}

