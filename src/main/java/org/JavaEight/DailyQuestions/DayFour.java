package org.JavaEight.DailyQuestions;

import org.JavaEight.JavaExamples.Address;
import org.JavaEight.JavaExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayFour {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));

//Q1. When should you use mapToInt(), mapToLong(), or mapToDouble() instead of map()?
        //Use when you have few list of employee
//        functionWithMap(employeeList);

        //Use when you have 10k list of employee
//        functionWithMapToInt(employeeList);


//Q2. When should you use Collectors.joining()?

//        String nameOfEmployees = employeeList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(", "));

//        System.out.println("Names of Employees : "+nameOfEmployees);


        // Q. When is Stream.generate() useful and what danger must you avoid?
        List<Integer> generateFiveOTP = Stream.
                generate(() -> new Random().nextInt(7) +1000 )
                .limit(5)
                .toList();

//        System.out.println(generateFiveOTP);


//       Q4 . Difference between sorted() and sorted(Comparator)
        //Works only if elements implement Comparable (String, Integer).

        //natural sorting
        List<String> normalSortingOfNames = employeeList.stream().map(Employee::getName).sorted().toList();

//        System.out.println(normalSortingOfNames);

        //Use this when natural sorting doesn't work.
        List<Employee> notNaturalSorting = employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();

//        System.out.println(notNaturalSorting);

        // name list of student



        // Q.5 When should you use Stream.concat()?
//        If you need to merge more than 2 lists → better to use Stream.of().flatMap().
        List<String> nameOfStudents1 = new ArrayList<>();

        nameOfStudents1.add("Omkar");
        nameOfStudents1.add("Rakmo");

        List<String> nameOfStudents2 = new ArrayList<>();
        nameOfStudents2.add("Jayesh");
        nameOfStudents2.add("Gaurav");

        String twoStreamOfNamesConcat = Stream
                .concat(nameOfStudents1.stream(), nameOfStudents2.stream())
                .collect(Collectors.joining(", "));

        System.out.println(twoStreamOfNamesConcat);






    }

    public static double functionWithMap(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
    }

    public static double functionWithMapToInt(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
