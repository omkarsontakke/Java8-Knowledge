package org.example.MockTest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_17012026 {
    public static void main(String[] args) {
        List<Character> charList = List.of('A','B','D','A','D');

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

        List<Character> list = charList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 2)
                .map(Map.Entry::getKey)
                .toList();

//        System.out.println(list);


//        Q.2 Find customers with no orders

        List<Customer> filterCustomer =  customers.stream()
                .filter(cust -> cust.getOrders() != null && !cust.getOrders().isEmpty())
                .toList();

//        System.out.println(filterCustomer);

//        Question 3: Find total oders amount of customer

        int sumOfCust =  customers.stream()
                .filter(fil -> fil.getOrders() != null)
                .flatMap(cust -> cust.getOrders().stream())
                .mapToInt(value ->(int) value.getAmount()).sum();

//        System.out.println(sumOfCust);

//        Q.4 Convert a list of strings to uppercase

        List<String> names = List.of("Omkar","Jayesh","Gaurav","Shlok");

        List<String> namesInUpperCase =  names.stream()
                .map(String::toUpperCase)
                .toList();

//        System.out.println(namesInUpperCase);

//       Q.5 Filter even numbers from a list

        List<Integer> numbers = List.of(423,532,1,52235,124,63,679,2);

        List<Integer> evenNumbers =  numbers.stream()
                .filter(num -> num %2 == 0)
                .toList();

//        System.out.println(evenNumbers);








    }
}
