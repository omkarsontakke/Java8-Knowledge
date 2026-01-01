package org.example.MockTest;

import javax.management.ValueExp;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mock_01012026 {
    public static void main(String[] args) {
//        Q.1  Count the frequency of each word in a sentence
//        o/p = {java=3, is=2, and=1, powerful=1}
        String sentence = "java is java and java is powerful";

        LinkedHashMap<String, Long> countOfEachWord = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

//        System.out.println(countOfEachWord);

//       Q2. Sort a Map by value using Java 8
        //        o/p : →
        Map<String, Integer> map = Map.of("A", 3, "B", 1, "C", 2);

        Map<String, Integer> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

//        System.out.println(collect);

//        3. Find all numbers starting with digit 1 using Java 8
        List<Integer> numbers = List.of(10, 15, 22, 18, 34, 19);

        List<Integer> numStartingWith1 = numbers.stream().
                filter(n -> n.toString().charAt(0) == '1')
                .collect(Collectors.toList());

//        System.out.println(numStartingWith1);


//        4. Find duplicate elements in a List using Java 8
        List<Integer> numbers1 = List.of(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> uniqueEle = new HashSet<>();

        List<Integer> duplicateElementInList = numbers1.stream().filter(n1 -> !uniqueEle.add(n1)).sorted().toList();

        System.out.println(duplicateElementInList);

    }
}
