package org.JavaEight.MockTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mock_01022026 {
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
                new Customer("Priya", "Delhi", 33,54000,null,List.of()),
                new Customer("Vikram", "Pune", 21,82000,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );




    //   Q.1 Find the total count of elements in a list

         List<String> lang = List.of("Java","Golang","SmallTalk","Ruby","Python");

         long sizeOfList = lang.size();

//         System.out.println(sizeOfList);

    //    Q.2 Find the longest string in a list

        Optional<String> maxLengthString = lang.stream()
                .max(Comparator.comparingInt(String::length));

//        maxLengthString.ifPresent(System.out::println);


        List<Integer> numList = List.of(1,2,3,4,5,6,7,7,8,9);


        List<String> list = numList.stream()
                .map(String::valueOf).toList();

//        System.out.println(list);

//        Find customers whose salary is greater than the average salary


        double average = customers.stream()
                .mapToInt(Customer::getSalary)
                .average()
                .orElse(0);

        System.out.println(average);

        List<Customer> customersAboveAvg  = customers.stream()
                .filter(cust -> cust.getSalary() > average)
                .collect(Collectors.toList());

//        System.out.println(customersAboveAvg );

        boolean isContainsDuplicate = numList.stream()
                .distinct()
                .count() != numList.size();

        System.out.println(isContainsDuplicate);

    }
}
