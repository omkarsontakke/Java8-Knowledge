package org.example.MockTest;

import java.util.Comparator;
import java.util.List;

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


        

    }



}
