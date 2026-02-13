package org.JavaEight.MockTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mock_13020206 {


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
                new Customer("Rohan", "Delhi", 33,54000,null,List.of()),
                new Customer("Rakmo", "Pune", 21,82000,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );



//      Q.1  Find Nth Highest Salary from Employee List
        int n = 2;
        Optional<Integer> NthHighestSalary = customers.stream()
                .map(Customer::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst();

        List<Integer> salry = customers.stream()
                .map(Customer::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

//        System.out.println(salry);

//        NthHighestSalary.ifPresent(System.out::println);

//      Q.2  Reverse Each Word in a String

        String str = "Java Stream API";

        String reverseWordInString = Arrays.stream(str.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));

//        System.out.println(reverseWordInString);

//       Q.3 Find Maximum and Minimum Number

        Optional<Integer> max = customers.stream()
                .map(Customer::getSalary)
                .max(Comparator.comparing(Integer::intValue));

        Optional<Integer> min = customers.stream()
                .map(Customer::getSalary)
                .min(Comparator.comparing(Integer::intValue));

//        max.ifPresent(System.out::println);
//        min.ifPresent(System.out::println);


//       Q.4 Find Common Elements Between Two Lists

        List<Integer> list1 = List.of(1,2,3,4);
        List<Integer> list2 = List.of(3,4,5,6);

        List<Integer> collect = list1.stream()
                .filter(n1 -> list2.contains(n1))
                .collect(Collectors.toList());

//        System.out.println(collect);

//      Q.5  Flatten a List of Lists

        List<List<Integer>> flattenList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> list = flattenList.stream()
                .flatMap(integers -> integers.stream())
                .toList();

        System.out.println(list);

    }

}
