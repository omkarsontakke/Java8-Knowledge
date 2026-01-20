package org.JavaEight.ScenarioBasedQuestions;


import org.JavaEight.JavaExamples.Address;
import org.JavaEight.JavaExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class ScenarioQuestion {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 790000000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 100.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("", "Maharashtra", "USA"), 540000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));
//        employeeList.add(new Employee("Jayesh", new Address("Bhiwandi", "Maharashtra", "America"), 100.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));
//        employeeList.add(new Employee("Shraddha", new Address("Panvel", "Maharashtra", "Canada"), 80000,Arrays.asList("om@gmail.com","ram@gmail.com")));
//        employeeList.add(new Employee("Aboli", new Address("Panvel", "Maharashtra", "India"), 97000,Arrays.asList("om@gmail.com","ram@gmail.com")));
//        employeeList.add(new Employee("Apurva", new Address("Panvel", "Maharashtra", "New York"), 50000,Arrays.asList("om@gmail.com","ram@gmail.com")));


        List<String> empNames =  employeeList.stream().map(Employee::getName).toList();
//        System.out.println("Names of the employees : "+empNames);
        List<String> empEmails =  employeeList.stream().flatMap(e -> e.getEmail().stream()).toList();
//        System.out.println("Names of the employees : "+empEmails);

        //Using List of stream
        Optional<Employee> firstSalaryGreaterthanX = employeeList.stream().filter(salary -> salary.getSalary() > 10000).findFirst();
        //Using List of stream
        List<Employee> empSalaries = employeeList.stream().filter(salary -> salary.getSalary() > 10000).toList();

//        System.out.println("Optional : Salaries of the employees greater tha 10000: "+firstSalaryGreaterthanX);
//        System.out.println("List : Salaries of the employees greater tha 10000: "+empSalaries);


        List<Double> empSalHikeList = employeeList
                .stream().
                filter(e -> e.getSalary() > 1000)
                .map(salary -> salary.getSalary() * 1.10).toList();

//        System.out.println("Employee Salaries with 10% hikes : "+empSalHikeList);

        //5. Scenario: Collectors.groupingBy
        //You have a list of transactions. You want: total amount spent per user

        Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.summingDouble(Employee::getSalary)));
//        System.out.println("Total Spend per Employee : "+collect);


        //6. Scenario: anyMatch vs allMatch vs noneMatch
        boolean isPresent = employeeList.stream()
                .map(Employee::getAddress).toList().stream()
                .anyMatch(c -> c.getCity().equals("Panel"));

//        System.out.println(isPresent);

        boolean isDepartmentIT = employeeList.stream().allMatch(e -> e.getDeptartment().equals("IT"));

//        System.out.println(isDepartmentIT);


        //7. Scenario: reduce() — Summing Values

//        long sumofSal = employeeList.stream()
//                .map(Employee::getSalary)
//                .reduce(1.0, Double::sum);

//        System.out.println("Sum of Salary: " + sumofSal);


//        Long highesSalOfEmployee = employeeList.stream()
//                .map(Employee::getSalary, Employee::getName)
//                .reduce(Long.MIN_VALUE, Long::max);

//        System.out.println("Highest Salary of Employee: " + highesSalOfEmployee);

        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(e -> System.out.println("Highest Pay Salary by "+e.getName() + " : " + e.getSalary()));



//        List<Employee> list = employeeList.stream()
//                .filter(e -> e.getSalary() <= 100)
//                .peek(e -> e.setSalary((e.getSalary() * 500)))
//                .toList();


//        System.out.println("Increment Salary by condition : "+list);


        //8. Scenario: Sorting with Comparator.comparing

        List<Employee> sortThaSal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName)).toList();

//        System.out.println("Salaries sorted by sal and age(if sal are same) "+sortThaSal);

        UUID uuid = UUID.randomUUID();
        Map<Integer, Employee> collect1 = employeeList.stream()
                .collect
                        (Collectors.toMap(Employee::generateUUID, e -> e));

        System.out.println(collect1);




        // Filter the empty values from the location
        List<String> stringStream = employeeList.stream()
                .map(Employee::getAddress)
                .map(Address::getCity)
                .map(String::trim)
                .filter(s -> s.isEmpty()).toList();

//        System.out.println(stringStream);


        Map<String, Optional<Employee>> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

//        System.out.println(collect2);


        List<Integer> fewDuplicateElem = List.of(2,6,6,9,3);

        Set<Integer> uniqeElem = new HashSet<>();

        List<Integer> integerStream = fewDuplicateElem.stream().filter(n -> !uniqeElem.add(n)).toList();
//        System.out.println(integerStream);

        Integer a = 1000;
        Integer b = 1000;

        System.out.println(a == b);

        List<Integer> list1 = List.of(2,6,6,9,3);
        List<Integer> list2 = List.of(2,5,7,9,1);

        List<Integer> list = list1.stream().filter(list2::contains).toList();
//        System.out.println(list);
    }

}
