package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        /*
        Для решения задачи надо использовать функционал StreamAPI вместо Scanner или подобного.

        StreamAPI функционал требует Stream<T> на вход, но System.in является InputStream, потоком байтов.

        Таким образом необходимо привести поток байтов в Stream<String> для того, чтобы можно было использовать
        нужный функционал StreamAPI, и решить задачу.

        InputStreamReader превращает поток байтов из System.in в поток символов.
        BufferedReader имеет метод .lines(), возвращающий необходимый Stream<String>

        Таким образом:
         */
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(x -> Stream.of(x.split("[\\P{L}&&\\D]"))) // не буква и не цифра
                .filter(x -> !x.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum)) // Добавляем элементы в хешмап
                .entrySet().stream() // Превращаем Set<Entry<String, Integer>> обратно в поток для дальнейшей работы.
                .sorted(Map.Entry.comparingByKey()) // Сортировка по лексикографическому порядку
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Сортировка по частоте
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + "\n")); // print + \n, вместо println
    }

}
