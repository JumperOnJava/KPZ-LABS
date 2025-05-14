package org.example.task3;

public final class Authenticator {
    private static volatile Authenticator instance;
    private Authenticator() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }
    public static Authenticator getInstance() {
        if (instance == null) {
            synchronized (Authenticator.class) {
                if (instance == null) {
                    instance = new Authenticator();
                }
            }
        }
        return instance;
    }
    public void login(String username, String password) {
        var nanos = System.nanoTime();
        System.out.println("THREAD "+Thread.currentThread().threadId()+") Logging in " + username + " with password hash" + password.hashCode()+ " in " + nanos + " nanoseconds");
    }
}
