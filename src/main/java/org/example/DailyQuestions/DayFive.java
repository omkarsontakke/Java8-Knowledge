package org.example.DailyQuestions;

import org.example.JavaExamples.Address;
import org.example.JavaExamples.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayFive {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {

        List<Employee> employeeListDayFive = new ArrayList<>();
        employeeListDayFive.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0, Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeListDayFive.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeListDayFive.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeListDayFive.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));




        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3);

        List<Integer> distNum = nums.stream().distinct().toList();

//        System.out.println(distNum);

        List<Employee> list = employeeListDayFive.stream().distinct().toList();

//        System.out.println(list);

//      Q2. When should you use skip() and limit()?
        List<Integer> list1 = nums.stream().skip(2).limit(4).toList();

//        System.out.println(list1);

        Stream.Builder<Employee> builder = Stream.builder();

        boolean filterByName = true;
        boolean filterByDept = false;

        if (filterByName) builder.accept(employeeListDayFive.get(5));

        Stream<Employee> filters = builder.build();

        List<Employee> collect = filters.collect(Collectors.toList());

        System.out.println(collect);


    }

}
