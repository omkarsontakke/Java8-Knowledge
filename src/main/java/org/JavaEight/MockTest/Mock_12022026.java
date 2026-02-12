package org.JavaEight.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_12022026 {
    public static void main(String[] args) {

//        Given a list of integers, find the duplicate elements using Java 8.
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 5, 3, 6);
        Set<Integer> uniqueElements = new HashSet<>();
        List<Integer> duplicateElements = numbers.stream()
                .filter(n -> !uniqueElements.add(n))
                .collect(Collectors.toList());

//        System.out.println(duplicateElements);


//        Count Occurrence of Each Character in a String

        String str = "swiss";

        Map<String, Long> frequencyOfCharInString = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(frequencyOfCharInString);

//        Find the Second Highest Number in a List

        Optional<Integer> secondHighestElement = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

//        secondHighestElement.ifPresent(System.out::println);


//        Separate Even and Odd Numbers

        Map<Boolean, List<Integer>> evenAndOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(evenAndOddPartition);

    }
}
