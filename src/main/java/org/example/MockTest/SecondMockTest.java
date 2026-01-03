package org.example.MockTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondMockTest {
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Amit", "Mumbai",11,
                        List.of(
                                new Order("O1", 1200, "DELIVERED"),
                                new Order("O2", 800, "NEW")
                        )
                ),
                new Customer("Neha", "Pune", 23,
                        List.of(
                                new Order("O3", 4000, "DELIVERED")
                        )
                ),
                new Customer("Rohan", "Mumbai", 31, null),
                new Customer("Priya", "Delhi", 33, List.of()),
                new Customer("Vikram", "Pune", 22,
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );


//        Q.1Task 1: Get all order IDs across all customers
//        ⚠ Handle null and empty orders safely.

        List<String> customerIdFromOrderClass = customers.stream()
                .filter(customer -> customer.getOrders() != null)
                .flatMap(custId -> custId.getOrders().stream())
                .map(Order::getId).toList();


          // System.out.println("Order ID's : "+customerIdFromOrderClass);


//        Task 2: Get total order amount (sum of all orders)
//        Use primitive stream (mapToDouble).

        double sumOfAmount = customers.stream().filter(order -> order.getOrders() != null)
                .flatMap(order -> order.getOrders().stream())
                .mapToDouble(Order::getAmount).sum();

        // System.out.println("Total Amount of Orders : " +sumOfAmount);


//        Task 3: Get all DELIVERED orders only
//        Return a List<Order> containing only delivered orders.

        List<Order> listOfCustIsDeliverd = customers.stream().filter(order -> order.getOrders() != null)
                .flatMap(order -> order.getOrders().stream())
                .filter(order -> order.getStatus() == "DELIVERED")
                .toList();

        // System.out.println("Customer List of Delivered status: " + listOfCustIsDeliverd.stream().toList());


//        Task 4: Group customers by city

        LinkedHashMap<String, List<Customer>> groupCustByCity = customers.stream().collect(Collectors.groupingBy(Customer::getCity, LinkedHashMap::new, Collectors.toList()));
//        System.out.println(groupCustByCity);

//        Task 5: Count number of orders per customer
//        Map<String, Integer> collect = customers.stream()
//                .collect(Collectors.toMap(
//                        Customer::getCity,
//                        customer -> Optional.ofNullable(customer.getOrders())
//                                .orElse(Collections.emptyList())
//                                .size()
//                ));
//        System.out.println(collect);


//        Map<Boolean, List<Customer>> collect1 = customers.stream()
//                .collect(Collectors.partitioningBy(
//                        cust -> Optional.ofNullable(cust.getOrders())
//                                .orElse(Collections.emptyList())
//                                .stream()
//                                .anyMatch(order -> order.getStatus() == "DELIVERED")));

//        System.out.println(collect1);


        List<String> custMobileNumbers = List.of("+918657237944", "+016633772288","+918767061072");

        List<String> list = custMobileNumbers.stream().filter(s -> s.startsWith("+9187")).peek(System.out::println).toList();
//        System.out.println(list);

        List<Integer> randomNumber = List.of(11,21,9,5,4,12,12,11);

        Optional<Integer> sumOfRandomNumber= randomNumber.stream().reduce(Integer::sum);

//        sumOfRandomNumber.ifPresent(System.out::println);

        Optional<Integer> secondLargestElement = randomNumber.stream().sorted(Comparator.reverseOrder()).skip(1).toList().stream().findFirst();

//        System.out.println(sorted);
//        secondLargestElement.ifPresent(System.out::println);


        List<String> wordOfList = List.of("Java","Python","Ruby","Kotlin","Java","Ruby");

//        System.out.println(wordOfList);

        Map<String, Long> frequencyOfEachWordInList = wordOfList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));

//        System.out.println(frequencyOfEachWordInList);

        List<Integer> evenNumAndSqurareOfThatNum = randomNumber.stream().filter(n -> n % 2 == 0).map(numSqu -> numSqu * numSqu).toList();

//        System.out.println(evenNumAndSqurareOfThatNum);


        String str = "swiss";

        Optional<String> firstNonRepeatingChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(firstNonRepeatingChar.isPresent());

//        customers.stream().collect(Collectors.groupingBy(Customer::getName, Collectors.averagingDouble(Customer::getOrders.) ));

//        System.out.println(collect);





    }


}
