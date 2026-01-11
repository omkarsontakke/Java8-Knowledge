package org.example.MockTest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_08012026 {
    public static void main(String[] args) {
        System.out.println("Complete the pending 08 Jan task...");

        // 1. Find the first non-repeated character in a String

        String input = "aabbcde";

        List<Map.Entry<String, Long>> result = input.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() == 1L)
            .collect(Collectors.toList());

            System.out.println(result);

        
    }
}
