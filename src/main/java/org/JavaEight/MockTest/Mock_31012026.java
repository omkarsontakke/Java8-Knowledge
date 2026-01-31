package org.JavaEight.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mock_31012026 {
    public static void main(String[] args) {

//       1. Find the average of a list of integers
        List<Integer> numbers = List.of(3,2,5,4,2,1,6,10,8,5,9,3,4);

        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();

//        average.ifPresent(System.out::println);

//      2. Find duplicate elements in a list

        Set <Integer> uniqueElem = new HashSet<>();

        List<Integer> duplicateNum = numbers.stream()
                .filter(n -> !uniqueElem.add(n))
                .collect(Collectors.toList());

//        System.out.println(duplicateNum);

//      3.Convert List<String> to Map<String, Long> (word → frequency)

        List<String> lang = List.of("Java","Swift","GoLang","Python","SmallTalk");

        // Not Preserved Insertion Order
        Map<String, Integer> stringLenght = lang.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println(stringLenght);

        // Preserving Insertion Order
        LinkedHashMap<String, Long> stringLength = lang.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.summingLong(String::length)));

//        System.out.println(stringLength);

//      Q.4 Find the first even number greater than 6

        Optional<Integer> first = numbers.stream()
                .filter(n -> n % 2 == 0 && n > 6)
                .findFirst();

//        first.ifPresent(System.out::println);


//      Q.5 Sort a list of strings by length

        List<String> sorted = lang.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(sorted);


    }
}
