package org.example.task1;

import org.example.task1.purchaseFlow.ManagerCall;
import org.example.task1.purchaseFlow.MobileApp;
import org.example.task1.purchaseFlow.PurchaseFlow;
import org.example.task1.purchaseFlow.Website;
import org.example.task1.subscription.Subscription;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.function.Supplier;

public class Task1 {
    //object that represents some student document.
    public static final Document STUDENT_DOCUMENT = new Document("80085");
    public static class Document{
        public final String document_id;
        public Document(String documentId) {
            document_id = documentId;
        }
    }

    public static void Main() {
        System.out.println("=== MobileApp Purchase Flow Showcase ===\n");

        runPurchaseScenario(() -> {
            MobileApp mobileApp = new MobileApp();
            mobileApp.mobileAppOnScreenClick(50, 250);
            return mobileApp;
        });

        runPurchaseScenario(() -> {
            MobileApp mobileApp = new MobileApp();
            mobileApp.mobileAppOnScreenClick(50, 50);
            mobileApp.captureStudentDocumentPhoto(() -> Task1.STUDENT_DOCUMENT);
            return mobileApp;
        });

        runPurchaseScenario(() -> {
            MobileApp mobileApp = new MobileApp();
            mobileApp.mobileAppOnScreenClick(50, 50);
            return mobileApp;
        });



        System.out.println("=== ManagerCall Usage Showcase ===");

        runPurchaseScenario(() -> {
            ManagerCall managerCall1 = new ManagerCall();
            managerCall1.sayInCall("Hello, I would like to purchase a subscription");
            managerCall1.sayInCall("I'm interested in the DOMESTIC subscription option");
            managerCall1.sayInCall("Yes, I agree to the terms and conditions");
            return managerCall1;
        });

        runPurchaseScenario(() -> {
            ManagerCall managerCall2 = new ManagerCall();
            managerCall2.sayInCall("Hello, I would like to purchase a student subscription");
            managerCall2.sayInCall("I'm a university student and can provide my student ID");
            managerCall2.sayInCall("Here is my student document with ID: " + Task1.STUDENT_DOCUMENT.document_id);
            managerCall2.sayInCall("Yes, I want to proceed with the STUDENT subscription");
            return managerCall2;
        });

        runPurchaseScenario(() -> {
            ManagerCall managerCall3 = new ManagerCall();
            managerCall3.sayInCall("Hello, I'm interested in getting a subscription");
            managerCall3.sayInCall("I'd like the STUDENT subscription because it's cheaper");
            managerCall3.sayInCall("I forgot to bring my student ID with me");
            managerCall3.sayInCall("Can I still get the STUDENT subscription rate?");
            return managerCall3;
        });



        System.out.println("=== Website Purchase Flow Showcase ===\n");

        runPurchaseScenario(() ->
                new Website(createInputStream("2\n")));

        runPurchaseScenario(() ->
                new Website(createInputStream("3\n80085\n")));

        runPurchaseScenario(() ->
                new Website(createInputStream("3\n12345\n")));
    }


    //overriden methods to print data as if it was entered in console
    private static ByteArrayInputStream createInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)){
            @Override
            public int read() {
                int b = super.read();
                if (b != -1) {
                    System.out.print(new String(new byte[]{(byte) b}, StandardCharsets.UTF_8));
                }
                return b;
            }

            @Override
            public int read(byte[] b, int off, int len) {
                int readBytes = super.read(b, off, len);
                if (readBytes > 0) {
                    String str = new String(b, off, readBytes, StandardCharsets.UTF_8);
                    System.out.print(str);
                }
                return readBytes;
            }

            @Override
            public int read(byte[] b) throws IOException {
                return read(b, 0, b.length);
            }
        };
    }

    private static void runPurchaseScenario(Supplier<PurchaseFlow> flowSupplier) {

        try {
            PurchaseFlow flow = flowSupplier.get();
            Subscription subscription = flow.finishPurchase();

            System.out.println("Purchase successful!");
            System.out.println("Subscription type: " + subscription.getName());
            System.out.println("Monthly price: $" + subscription.getPrice());
        } catch (InvalidParameterException e) {
                System.out.println("Purchase failed: " + e.getMessage());
        }

        System.out.println("\n------------------------------------\n");
    }
}