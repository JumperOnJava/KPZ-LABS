package org.example.task1.purchaseFlow;

import org.example.task1.Task1;
import org.example.task1.subscription.Subscription;
import org.example.task1.subscription.SubscriptionType;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MobileApp extends PurchaseFlow {

    private Supplier<Object> documentPhoto;
    private SubscriptionType subscriptionType;

    public MobileApp() {}

    public void captureStudentDocumentPhoto(Supplier<Object> documentPhoto){
        this.documentPhoto = documentPhoto;
    }
    public void mobileAppOnScreenClick(int x, int y){
        var list = Map.of(
                new int[]{50, 50, 50}, SubscriptionType.STUDENT,
                new int[]{50, 150, 50}, SubscriptionType.DOMESTIC,
                new int[]{50, 250, 50}, SubscriptionType.PREMIUM);
        for (var entry : list.entrySet()) {
            if(intersects(x,y,entry.getKey()[0],entry.getKey()[1],entry.getKey()[2] )){
                subscriptionType = entry.getValue();
            }
        }
    }
    public static boolean intersects(double pointX, double pointY,
                                     double cubeX, double cubeY, double cubeSize) {
        return pointX >= (cubeX - cubeSize / 2.0) && pointX <= (cubeX + cubeSize / 2.0) &&
                pointY >= (cubeY - cubeSize / 2.0) && pointY <= (cubeY + cubeSize / 2.0);
    }


    @Override
    public Subscription finishPurchase() throws InvalidParameterException {
        if(subscriptionType == SubscriptionType.STUDENT){
            if(documentPhoto != null && documentPhoto.get() != Task1.STUDENT_DOCUMENT){
                throw new InvalidParameterException("Student document is incorrect");
            }
        }
        return subscriptionType.createSubscription();
    }
}

