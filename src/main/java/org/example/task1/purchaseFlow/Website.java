package org.example.task1.purchaseFlow;

import org.example.task1.Task1;
import org.example.task1.subscription.Subscription;
import org.example.task1.subscription.SubscriptionType;

import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Scanner;

public class Website extends PurchaseFlow {

    private final InputStream input;

    public Website(InputStream input) {
        this.input = input;
    }

    @Override
    public Subscription finishPurchase() throws InvalidParameterException {
        Scanner scanner = new Scanner(input);
        SubscriptionType[] types = SubscriptionType.values();
        SubscriptionType selectedType = null;

        while (selectedType == null) {
            System.out.println("Select subscription type:");
            for (int i = 0; i < types.length; i++) {
                System.out.printf("%d. %s%n", i + 1, types[i]);
            }
            System.out.print("Enter a number (1-" + types.length + "): ");

            String input = scanner.nextLine();

            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < types.length) {
                    selectedType = types[index];
                } else {
                    throw new InvalidParameterException("Number out of range.");
                }
            } catch (NumberFormatException e) {
                throw new InvalidParameterException("Invalid input. Please enter a number.");
            }

            if(selectedType == SubscriptionType.STUDENT) {
                System.out.println("Student subscription requires student document id [dev note: id is 80085].");
                String document_id = scanner.nextLine();
                if(!Objects.equals(document_id, Task1.STUDENT_DOCUMENT.document_id)) {
                    throw new InvalidParameterException("Document id incorrect.");
                }
            }
        }

        return selectedType.createSubscription();
    }
}

