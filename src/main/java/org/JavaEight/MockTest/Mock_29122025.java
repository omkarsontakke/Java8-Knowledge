package org.JavaEight.MockTest;

import java.util.*;
import java.util.stream.Collectors;

public class Mock_29122025 {
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

        String duplicateChar = "banana";

//        1. Count occurrences of each character in a String
//        Example: "banana" → {b=1, a=3, n=2}

        Map<String, Long> keyValuePairs = Arrays.stream(duplicateChar.split(""))
                .collect(Collectors.groupingBy(s -> s,LinkedHashMap::new ,Collectors.counting()));

//        System.out.println(keyValuePairs);

//        2. Find duplicate elements in a List
//        Example: [1, 2, 3, 2, 4, 3] → [2, 3]

        List<Integer> numbers = Arrays.asList(200);
        Set<Integer> uniqueElements = new HashSet<>();
        List<Integer> duplicateElements = numbers.stream().filter(num -> !uniqueElements.add(num)).collect(Collectors.toList());

//        System.out.println(duplicateElements);

//        3. Find the first non-repeated character in a String
//        Example: "swiss" → w

        String str = "aaffswiss";

        Optional<String> NonRepChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

//        System.out.println(NonRepChar.get());

//        4. Sort a Map by values (ascending or descending)
//        Input: Map<String, Integer>

        LinkedHashMap<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(s -> s,LinkedHashMap::new, Collectors.counting()));

//        System.out.println(collect);


//        5. Given a list of integers, find the maximum and minimum without using loops

        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);

//        System.out.println("Maximum element : "+max.get());
//        System.out.println("Minimum element : "+min.get());

//        6. Convert a List of Strings to uppercase and remove duplicates
//        Example: ["java", "Java", "python"] → ["JAVA", "PYTHON"]

        List<String> languages = Arrays.asList("java", "Java", "python");
        List<String> removeDuplicateAndToUpperCase = languages.stream().map(String::toUpperCase).distinct().toList();
//        System.out.println(removeDuplicateAndToUpperCase);

//        7. Group a list of employees by city
        Map<String, List<Customer>> groupCustByCity = customers.stream().collect(Collectors.groupingBy(Customer::getCity));

//        System.out.println(groupCustByCity);

//        8. Find the second highest number in a list

        Integer i = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(i);

//        9. Use Optional to avoid NullPointerException
//        Question:
//        How would you safely get a value from an object that may be null using Optional?
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

//        10. Difference-based coding question
//
//        Question:
//        Convert this traditional loop into Java 8:
//
//        for (int i : list) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }

        List<Integer> evenNum = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNum);
    }

}
