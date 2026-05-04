package com.goks.cache;

public class FakeDatabase {

    public String getUser(String userId) {
        try {
            Thread.sleep(100); // simulate slow DB
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "User-" + userId;
    }
}
