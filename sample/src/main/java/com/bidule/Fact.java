package com.bidule;

public class Fact {
    public int fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        }
        return n == 0 ? 1 : n * fact(n - 1);
    }
}
