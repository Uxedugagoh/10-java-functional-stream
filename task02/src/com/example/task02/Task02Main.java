package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        /*
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
        */

    }

    // Честно говоря, не особо понял что тут происходит вообще. Правильную реализацию грей кода посмотрел.
    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("n должно быть в [1 - 16]");
        }

        int size = 1 << n; // 2^n

        // .map применяет нужную формулу (XOR к самому себе, сдвинутому на бит вправо) ко всем элементам в стриме.
        // Как я понял, size вычисляется также нужным для кода грея параметрам.
        return IntStream.iterate(0, i -> (i + 1) % size)
                .map(i -> i ^ (i >> 1));

    }
    // samara...
}
