package org.JavaEight.DailyQuestions;

import org.JavaEight.JavaExamples.Address;
import org.JavaEight.JavaExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DayTwo {
    public static void main(String[] args) {
        // When to use filter() → map():

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));


        List<Double> doubleStream = employeeList.stream().filter(employee -> employee.getSalary() > 54000).map(employee -> employee.getSalary() * 1.10).toList();

//        System.out.println(doubleStream);

        // When to use map() → filter():

        List<Double> list = employeeList.stream().map(employee -> employee.getSalary() * 1.10).filter(e -> e > 70000).toList();

//        System.out.println("Employee salary higher than 70k when increment "+list);


        // Q.2 When should you use peek()?

        List<Employee> list1 = employeeList.stream()
                .filter(e -> e.getSalary() > 54000)
                .peek(employee -> System.out.println("Employee salary higher than {54000} :  " + employee.getSalary()))
                .toList();

//        System.out.println(list1);


//       Q.3 When should you use reduce()?
        Double sumOfSal =  employeeList.stream()
                .filter(employee -> employee.getSalary() > 54000)
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

//        System.out.println(sumOfSal);

//        Q4. When to use Comparator.comparing() vs thenComparing()?

        List<Employee> list2 = employeeList.stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).toList();

//        System.out.println(list2);


        // 5. When to use Collectors.toMap() & when exception occurs
//        Map<Double, String> empMap = employeeList.stream()
//                .collect(Collectors.toMap(Employee::getSalary, Employee::getName));

//        System.out.println(empMap);

        // 6. Find the missing number from list

        int[] array = {2,4,3,6,7,8,9,1};

        Set<Integer> uniqueElements = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());

        List<Integer> absentNumber = IntStream.rangeClosed(1, 9)
                .filter(num -> !uniqueElements.contains(num))
                .boxed()
                .toList();

        List<Integer> cubeOfNumGretThan30 = uniqueElements.stream().map(num -> num * num * num).filter(num -> num > 30).toList();

        List<Integer> list3 = IntStream.rangeClosed(1, 9).boxed().toList();

//        System.out.println("List: " + list3);
//
//        System.out.println(absentNumber);

//        System.out.println(cubeOfNumGretThan30);


        // Q. Move zero elements to the left side of the list and right to the non zero elements.

        int[] listOfNum = {-1,0,5,0,0,4,9,3,2,1,1,0,0};

        List<Integer> list4 = Arrays.stream(listOfNum).boxed().toList();

        List<Integer> listOfZeroAndNonZero = Stream.concat(list4.stream().filter(num -> num == 0), list4.stream().filter(num -> num != 0)).toList();

//        System.out.println(listOfZeroAndNonZero);






    }
}
