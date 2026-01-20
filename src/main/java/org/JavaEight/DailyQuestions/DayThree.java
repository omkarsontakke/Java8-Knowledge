package org.JavaEight.DailyQuestions;

import org.JavaEight.JavaExamples.Address;
import org.JavaEight.JavaExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThree {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Om", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));



        // 1. When should you prefer Stream.of() vs Arrays.stream()?
        Stream<String> stringStream = Stream.of("desh", "Bhavaesh", "Chandu", "Deppak", "Emmaran", "Dipa");

        List<String> nameStartWithD =  stringStream.filter(s -> s.toUpperCase().startsWith("D")).toList();

//        System.out.println("Names start with : "+ nameStartWithD);

        int[] evenNumber = {2,4,6,8,10};

        int[] arrayGreaterThanFive = Arrays.stream(evenNumber).filter(num -> num > 5).toArray();

//        System.out.println(arrayGreaterThanFive.length);

//        for (int i : arrayGreaterThanFive)
//            System.out.println(i);


        // When should you use findFirst() vs findAny()?
        List<String> integerList = Arrays.asList("rakmaao","omkaaar","jaaayesh","gaurav");

        Optional<String>  a = integerList.stream().filter(s -> s.length() <= 5).findAny().orElse("Default").describeConstable();

        String strFiveChar = a.get();

//        System.out.println("Output: "+ strFiveChar);

        Map<Boolean, List<Employee>> lenGreaterThan4 = employeeList.stream().collect(Collectors.partitioningBy(s -> s.getName().length() > 4));

//        System.out.println(lenGreaterThan4);


        //Q.  When you want the specific MAP like LinkedHashMap, TreeMap; Default is HashMap
        Map<String, Double> collect = employeeList.stream().collect(
                Collectors.toMap(Employee::getName, Employee::getSalary,(oldVal, newVal) -> newVal, TreeMap::new)
        );

        System.out.println(collect);

        System.out.println(collect.getClass());
    }
}
