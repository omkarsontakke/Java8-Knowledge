package org.JavaEight.MockTest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_20012025 {
    public static void main(String[] args) {
//        Question 1: Find maximum number in a list

        List<Integer> numbers = List.of(1,5,6,7,3,2,1,7);

        Integer maxElement = numbers.stream()
                .max(Integer::compareTo)
                .orElse(null);

//        System.out.println("Max Element : "+maxElement);

//        Question 2: Remove duplicate elements from a list

        List<Integer> removeDuplicateEleList = numbers.stream()
                .distinct()
                .toList();

//        System.out.println(removeDuplicateEleList);


//        Question 3: Count total elements in a list

        long countOfElement = numbers.stream()
                .count();

        int size = numbers.size();

//        System.out.println("Total Element Count : "+countOfElement + ", " +size);

//        Question 4: Find the length of each string in a list

        List<String> programmingLanguage = List.of("Java","Python","C","Ruby");

        List<Integer> lenghtOfStringCount = programmingLanguage.stream()
                .map(String::length)
                .toList();

        System.out.println(lenghtOfStringCount);

        Map<String, Integer> collect = programmingLanguage.stream()
                .collect(Collectors.toMap(Function.identity(), String::length
                ));

//        System.out.println(collect);


//        Question 5: Check if any number is greater than a given value

        boolean isGreater = numbers.stream()
                .anyMatch(num -> num > 7);

        System.out.println(isGreater);

    }



}
