package org.example.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mock_03012026 {

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Amit", "Mumbai",21,32100,"Active",
                        List.of(
                                new Order("O1", 1200, "DELIVERED"),
                                new Order("O2", 800, "NEW")
                        )
                ),
                new Customer("Neha", "Pune",17,11000,"Active",
                        List.of(
                                new Order("O3", 4000, "DELIVERED")
                        )
                ),
                new Customer("Rohan", "Mumbai",42,82000, "InActive",null),
                new Customer("Priya", "Delhi", 33,54000,"InActive",List.of()),
                new Customer("Vikram", "Pune", 21,32100,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );



//        Question 1: Find the longest string in a List

        List<String> tech = List.of("java", "springboot", "microservices", "api");

        Optional<String> reduce = tech.stream()
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2);

//        reduce.ifPresent(System.out::println);

//        Question 2: Partition numbers into even and odd using Java 8

        List<Integer> numbers = List.of(121,2,3,4,5,6,7);

        Map<Boolean, List<Integer>> collect = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 != 0));

//        System.out.println(collect);

//        Question 3: Find the first non-repeated character in a String

        String input = "javaisawesome";

        Optional<String> firstNonRep = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

//        firstNonRep.ifPresent(System.out::println);

//        Question 4: Remove duplicate characters from a String while preserving order

        String inputProgramming = "programming";

        String distinctCharString = Arrays.stream(inputProgramming.split(""))
                .distinct().collect(Collectors.joining(""));

//        System.out.println(distinctCharString);


//        Question 5: Find customers whose age is greater than the average age

        double avgAge = customers.stream()
                .mapToInt(Customer::getAge)
                .average()
                .orElse(0.0);

        List<Customer> listOfCustGreaterThanAvg = customers.stream()
                .filter(e -> e.getAge() > avgAge)
                .toList();

        System.out.println(listOfCustGreaterThanAvg);

    }

}
