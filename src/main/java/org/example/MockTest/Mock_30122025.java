package org.example.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_30122025 {
    public static void main(String[] args) {
        System.out.println("Started day 30 of java 8");

//        Q.1. Find duplicate elements in a list
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Set<String> listEle = new HashSet<>();
        List<String> collect = list.stream().filter(s -> !listEle.add(s)).toList();
//        System.out.println("Duplicate Elements in the given list : " +collect);

//        Q.2. Count occurrences of each element in a list

        Map<String, Long> occurrenceOfEachElemInList = list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

//        System.out.println("Occurrence of each elements in the list : "+occurrenceOfEachElemInList);


//       Q.3 Find the first non-repeated character in a string

        String cityName = "india";

        Optional<String> first = Arrays.stream(cityName.split(""))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(first.get());

    }

}


