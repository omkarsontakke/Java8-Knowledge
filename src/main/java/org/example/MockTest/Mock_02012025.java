package org.example.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_02012025 {
    public static void main(String[] args) {
//        Q1. Find the first repeating character in a String using Java 8\

        String str = "Programming";

        Arrays.stream(str.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .skip(1)
                .filter(stringLongEntry -> stringLongEntry.getValue() == 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);

//        System.out.println(first);

//        Q2. Find the second highest number from a List using Java 8

        List<Integer> numbers = List.of(10, 20, 5, 30, 20);

        numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);


//      Q.3  Convert a List of Strings into a Map<String, Integer> where value is string

        List<String> programmingLang = List.of("java", "c++", "python","java");

        Map<String, Integer> collect = programmingLang.stream().distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));

//        System.out.println(collect);


//        Check if a List contains any duplicate elements using Java 8

        List<Integer> num = List.of(1, 2, 3, 4, 2);

        boolean isListContainDuplicate = num.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count > 1);

        System.out.println(isListContainDuplicate);


    }
}
