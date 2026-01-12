package org.example.MockTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mock_08012026 {

    public static void main(String[] args) {


//        Q.1 Convert List into to map, Note: If key is duplicate use new key

        List<User> list = Arrays.asList(
                new User("Omkar", "Rakmo"),
                new User("Rakmo", "Omkar"),
                new User("Rakmo", "RAM")
        );

        Map<String, String> collect =
                list.stream()
                .collect(Collectors.toMap(
                        User::username,
                        User::password,
                        (oldKey, newKey) -> newKey
                ));

//        System.out.println(collect);

//        Question 2: Find customers whose total order amount is greater than 5000

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


        List<Order> list1 = customers.stream()
                .filter(n -> n.getOrders() != null)
                .flatMap(c -> c.getOrders().stream())
                .mapToInt(Order::getAmount)
                .sum();


        System.out.println(list1);


    }

}
