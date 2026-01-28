package org.JavaEight.MockTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_28102026 {
    public static void main(String[] args) {

//      1. Find distinct elements and preserve insertion order
        List<Integer> numbers = List.of(2,1,4,3,7,5,8,1,2,5);

        List<Integer> list = numbers.stream()
                .distinct()
                .toList();

//        System.out.println("Duplicate Elemnt "+list);

//      2. Find the sum of all even numbers

        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

//        System.out.println(sumOfEvenNumbers);


//      Q.3 Convert List<String> to Map<String, Integer> (String → length)
        List<String> lang = List.of("Java","Hibernate","Spring");

        Map<String, Integer> keyPairsValue = lang.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

//        System.out.println(keyPairsValue);

//      Q.4 Find the first element greater than a given value

        int givenNum = 6;

        Optional<Integer> first = numbers.stream()
                .filter(num -> num > givenNum)
                .findFirst();

//        first.ifPresent(System.out::println);

//      Q.5 Count how many strings have length greater than 4
        long countOfString = lang.stream()
                .filter(lan -> lan.length() > 4)
                .count();

        System.out.println(countOfString);


    }
}
