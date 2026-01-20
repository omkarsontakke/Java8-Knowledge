package org.JavaEight.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_13012026 {
    public static void main(String[] args) {
//        Question 1: Partition List into even and odd numbers.

        List<Integer> numbersEvenOdd = List.of(10, 15, 20, 25, 30);

        Map<Boolean, List<Integer>> collect = numbersEvenOdd.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

//        System.out.println(collect.get(true));


//        Question 2 : Convert a list of strings to uppercase

        List<String> names = List.of("java", "spring", "boot");

        List<String> namesUpperCase = names.stream()
                .map(String::toUpperCase).toList();

//        System.out.println(namesUpperCase);

//        Question 3: Count occurrences of each element in a list

        List<String> languages = List.of("java", "python", "java", "c", "python", "java");

        Map<String, Long> collect1 = languages.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

//        System.out.println(collect1);

//        Question 4 : Find the first non-repeated character in a string
        String input = "swiss";

        String firstNonRepeatingChar = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

//        System.out.println(firstNonRepeatingChar);


//        Question 5 : Find the second-highest number in a list

        List<Integer> numbers = List.of(10, 20, 30, 20, 40);

        Integer secondHigh = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);

        System.out.println(secondHigh);


    }
}
