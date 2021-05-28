package fr.chose;

import java.util.stream.IntStream;

public record Stats(int min,
                    int max,
                    int sum,
                    double avg) {

    public static Stats of(int... numbers) {
        int sum = IntStream.of(numbers).sum();
        return new Stats(
            IntStream.of(numbers).min().orElse(0),
            IntStream.of(numbers).max().orElse(0),
            IntStream.of(numbers).sum(),
            IntStream.of(numbers).average().orElse(0));
    }
}
