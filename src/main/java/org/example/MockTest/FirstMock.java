package org.example.MockTest;

import org.example.JavaExamples.Address;
import org.example.JavaExamples.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstMock {
    public static void main(String[] args) {


        List<Employee> employeeListMock = new ArrayList<>();
        employeeListMock.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeListMock.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeListMock.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeListMock.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));


        List<Customer> customers = List.of(
                new Customer("Amit", "Mumbai",21,32100,
                        List.of(
                                new Order("O1", 1200, "DELIVERED"),
                                new Order("O2", 800, "NEW")
                        )
                ),
                new Customer("Neha", "Pune",17,11000,
                        List.of(
                                new Order("O3", 4000, "DELIVERED")
                        )
                ),
                new Customer("Rohan", "Mumbai",42,82000, null),
                new Customer("Priya", "Delhi", 33,54000,List.of()),
                new Customer("Vikram", "Pune", 21,32100,
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );

        List<String> listOfCustID = customers.stream()
                .filter(c -> c.getOrders() != null)
                .flatMap(customer -> customer.getOrders().stream())
                .map(Order::getId)
                .toList();

//        System.out.println(listOfCustID);


        Map<String, Double> collect = employeeListMock.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary, (old, newVal) -> newVal));

//        System.out.println(collect);


        List<String> names = new ArrayList<>();
        names.add("Omkar");
        names.add("Jayesh");
        names.add("Gaurav");
        names.add("Akshay");
        names.add("Cyber");
        names.add("Vikram");
        names.add("Neha");
        names.add("Hariwandi");
        names.add("Sanket");

//        System.out.println("Before Modifying : " +names);

//        names.stream().forEach(name -> names.addLast( " IT"));

//        System.out.println("After Modifying : " +names);

        // Remove duplicate elements from the list
        List<Integer> list = List.of(2,1,5,7,2,3,51,1,5,2);

        List<Integer> nonDuplicateElements = list.stream().distinct().collect(Collectors.toList());

//        System.out.println(nonDuplicateElements);

        //Find the frequency of each character in the give string

        String str = "Omkar Anil Sontakke";


        Map<String, Long> countingOfEachCharacterInStr = Stream.of(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(countingOfEachCharacter);

        //
        Map<Integer, Long> countingOfEachCharacterInList = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(countingOfEachCharacterInList);


        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        List<Double> sorted = decimalList.stream().sorted(Comparator.comparingDouble(Double::doubleValue).reversed()).toList();

//        System.out.println("Sorted Elements in Descending Order : "+sorted);


        //6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String prefixSuffixOpt = listOfStrings.stream()
                .collect(Collectors.joining("," ,"{", "}"));



//        System.out.println(prefixSuffixOpt);

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89,100);
        List<Integer> listOfIntegers1= Arrays.asList(100);

        List<Integer> multipleOf5 = listOfIntegers.stream().filter(integer -> integer % 5 == 0).toList();

//        System.out.println(multipleOf5);

//        8) Given a list of integers, find maximum and minimum of those numbers?
        Optional<Integer> min = listOfIntegers.stream().min(Integer::compareTo);
//        System.out.println(min.get());

        Optional<Integer> max = listOfIntegers.stream().max(Integer::compareTo);
//        System.out.println(max.get());

//        int[] array1 = IntStream.concat( listOfIntegers.stream().mapToInt(i -> i),  listOfIntegers1.stream().mapToInt(i)).sorted().toArray();



//        System.out.println(Arrays.toString(array1));
        
        // Q. Find the first non-repeating character in the given string
        
        String str1 = "swisss";

        String firstNonRepeatingCharacter = Arrays.stream(str1.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting())
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
//        System.out.println(firstNonRepeatingCharacter);


         /*
         Find the Bigream from the give string.
         Example Input  : "Java is the best, Java is the robust, and Java is Great"
                 Output : Java is :3 , is the:2 , is the:1, the best, , :1 , ...
         */

        String biGramString = "Java is the best, Java is the robust, and Java is Great";

        String[] splitStringWithSpace = biGramString.split(" ");

        List<String> list1 = IntStream.range(0, splitStringWithSpace.length -1 )
                .mapToObj(i -> splitStringWithSpace[i] + " " + splitStringWithSpace[i + 1])
                .toList();

        Map<String, Long> collect1 = list1.stream().collect(Collectors.groupingBy
                (Function.identity(),LinkedHashMap::new,  Collectors.counting()));

//        System.out.println(collect1);


        List<String> list2 = customers.stream()
                .filter(customer -> customer.getOrders() != null)
                .flatMap(customerId -> customerId.getOrders().stream())
                .map(Order::getId).toList();

        System.out.println(list2);


    }


}
