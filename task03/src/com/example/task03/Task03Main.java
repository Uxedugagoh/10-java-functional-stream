package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        // Iterator - проход за один раз, возможность использовать ручной цикл, сработает с огромным набором данных.
        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T current = iterator.next();
        T min = current;
        T max = current;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (order.compare(min, current) > 0) {
                min = current;
            }
            if (order.compare(max, current) < 0) {
                max = current;
            }
        }
        minMaxConsumer.accept(min, max);
    }
}
