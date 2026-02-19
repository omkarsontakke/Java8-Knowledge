package org.JavaEight.MockTest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_19020206 {

    public static void main(String[] args) {

        // Q. Count Character Frequency
        String str = "programming";

        Map<Character, Long > frequencyOfChar =  str.chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

//        System.out.println(frequencyOfChar);

        // Q. Sum of Square of Even numbers.

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,0);

        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(squr -> squr * squr)
                .mapToInt(Integer::intValue)
                .sum();
//        System.out.println(sumOfEvenNumbers);

        // Q. EVEN and ODD Numbers

        Map<Boolean, List<Integer>> collect = numbers.stream()
                .collect(Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println(collect);

    }
}
