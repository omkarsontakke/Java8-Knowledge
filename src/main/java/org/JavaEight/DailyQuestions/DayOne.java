package org.JavaEight.DailyQuestions;

import org.JavaEight.JavaExamples.Address;
import org.JavaEight.JavaExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayOne {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));


        List<String> empNames =  employeeList.stream().map(Employee::getName).toList();
//        System.out.println("Names of employees: " + empNames);
        List<String> list = employeeList.stream().flatMap(e -> e.getEmail().stream()).toList();
//        System.out.println("Emails of employees: " + list);


        Map<String, List<Employee>> empGrpByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
//        System.out.println("Employee Group by Department : "+empGrpByDept);

//        List<Optional<String>> list = employeeList.stream().map(e -> Optional.of(e.getDeptartment())).toList();
//        System.out.println(list);

        Stream<Optional<String>> optionalStream = employeeList.stream().map(e -> Optional.ofNullable(e.getName()));
//        System.out.println(optionalStream);

        employeeList.stream().map(Employee::getName).forEach(e -> System.out.println(e.toUpperCase()));
        List<String> collectMethodUse = employeeList.stream().map(Employee::getDeptartment).collect(Collectors.toList());
//        System.out.println(collectMethodUse);

//        IntStream.rangeClosed(0,10).forEach(e -> System.out.println("Thread "+ Thread.currentThread().getId()));
    }
}
