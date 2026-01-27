package org.JavaEight.MockTest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Mock_27012026 {
    public static void main(String[] args) {
//        Given List<Integer>, return a list where each number is squared.

        List<Integer> numbers = List.of(1,2,9,4,9,7,8,8,5,6,7);

        List<Integer> squareOfNumbers =  numbers.stream()
                .map(num -> num*num)
                .toList();

//        System.out.println(squareOfNumbers);

//        From List<String>, return only strings that start with "A".

        List<String> lang = List.of("Omkar","Anushka","Anuj", "Shlok","Apurva","Anushka");

        List<String> langStartWithA = lang.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

//        System.out.println(langStartWithA);


//        Count how many numbers are greater than 20 in a list.

        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
//        System.out.println(count);


//        Convert List to Set Using Java 8

        Set<String> collect = lang.stream()
                .collect(Collectors.toSet());

//        System.out.println(collect);

//        Find the Maximum Number in a List

        int i = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();

        System.out.println(i);

    }

}
