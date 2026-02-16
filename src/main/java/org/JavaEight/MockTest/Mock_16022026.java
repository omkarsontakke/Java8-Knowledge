package org.JavaEight.MockTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Mock_16022026 {
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


//     Increase salary by 10% for employees who joined before 2020

        List<Double> list = customers.stream()
                .filter(cust -> cust.getOrders() != null)
                .map(custSal -> custSal.getSalary() * 0.10)
                .toList();

//        System.out.println(list);

        //Calculate total transaction amount using reduce()

        Integer reduce = customers.stream()
                .map(Customer::getSalary)
                .reduce(0, Integer::sum);

        System.out.println(reduce);

    }
}
