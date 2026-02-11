package org.JavaEight.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mock_11022026 {
    public static void main(String[] args) {
//      Q.1  Given a list of integers, remove duplicates using Java 8.

        List<Integer> numbers = List.of(1,2,1,3,2,4,3,5,4,6,5,7,6);

        List<Integer> uniqueElements =   numbers.stream()
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(uniqueElements);


//      Q.2 Find the second-highest number in a list using Java 8.

        Optional<Integer> secondHighestElement =  numbers.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .skip(1)
                .limit(1)
                .findFirst();

//        secondHighestElement.ifPresent(System.out::println);

//      Q.3 Count Occurrence of Each Character in a String

        String greeting = "namaste";

        Map<String, Long> frequencyOfChar =  Arrays.stream(greeting.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(frequencyOfChar);

//      Q.4  Find All Even Numbers from a List

        List<Integer> evenElements = numbers.stream()
                .filter(num -> num %2 == 0)
                .collect(Collectors.toList());

//        System.out.println(evenElements);


//      Q.5 Find the First Non-Repeated Character in a String

        String str = "swiss";

        String firstNonRepeatingCharacter = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(key -> key.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(firstNonRepeatingCharacter);

    }
}
