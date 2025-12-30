package org.example.JavaExamples;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//        List<String> sortNumber = new ArrayList<String>();
//        sortNumber.add("Omkar");
//        sortNumber.add("Rakmo");
//        sortNumber.add("ICICI");
//        sortNumber.add("Allied");
//
//        System.out.println("Before Sorting ");
//        sortNumber.forEach(num -> System.out.println(num));
//        System.out.println("--------------");
//        Collections.sort(sortNumber, (n1,n2) -> n1.compareToIgnoreCase(n2));
//        System.out.println("After Sorting ");
//        System.out.println("--------------");
//        sortNumber.forEach(num -> System.out.println(num));

//        List<Integer> sortNumber = new ArrayList<Integer>();
//        sortNumber.add(7);
//        sortNumber.add(3);
//        sortNumber.add(8);
//        sortNumber.add(9);
//
//        System.out.println("Before Sorting ");
//        sortNumber.forEach(num -> System.out.println(num));
//        System.out.println("--------------");
//        Collections.sort(sortNumber, (n1,n2) -> n1.compareTo(n2));
//        System.out.println("After Sorting ");
//        System.out.println("--------------");
//
//        sortNumber.forEach(System.out::println);


//        List<Integer> testInt = new ArrayList<Integer>();
//        testInt.add(8);
//        testInt.add(3);
//        testInt.add(2);
//        testInt.add(5);
//        testInt.add(1);
//        testInt.add(7);
//
//
//
//        Collections.sort(testInt, Integer::compareTo);
//
//        testInt.forEach(System.out::println);
//
//        List<Integer> evenNum =  testInt.stream().filter(n -> n%2 ==0).collect(Collectors.toList());
//
//        System.out.println("Even Numbers");
//
//        evenNum.forEach(System.out::println);
//
//        System.out.println("ODD Numbers");
//
//        List<Integer> oddNum =  testInt.stream().filter(n -> n%2 != 0).toList();
//
//        oddNum.forEach(System.out::println);
//
//        int sumofOddNum = oddNum.stream().reduce(0,(a,b) -> a+b);
//        System.out.println("Sum of the Odd Numbers : "+sumofOddNum);
//
//        int sumofEvenNum = evenNum.stream().reduce(0, (n1,n2) -> n1+n2);
//        System.out.println("Sum of the Even Numbers : "+sumofEvenNum);

        //-------------------------------------------------------------
        //Problem 1: Given a list of strings, print each string using forEach and a lambda.

//        List<String> fruits = Arrays.asList("Mango","Apple", "Banana");

        //fruits.forEach(fruit -> System.out.println(fruit));
//        or
        //fruits.forEach(System.out::println);
        //-------------------------------------------------------------
//      Problem 2: Given a list of integers, use Stream + filter + lambda to return only even numbers.
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        List<Integer> even = numbers.stream().filter((n1) -> n1%2==0).toList();

        //even.forEach(System.out::println);

        //-------------------------------------------------------------
//      Problem 3: Convert Strings to Uppercase
//        List<String> names = Arrays.asList("john", "doe", "alice");
//
//        List<String> upperCaseNames = names.stream().map(name -> name.toUpperCase()).toList();

//        upperCaseNames.forEach(System.out::println);

        //-------------------------------------------------------------
//      Problem 4: Sort a List in Reverse Order
//        List<String> items = Arrays.asList("Zebra", "Monkey", "Apple");
//
//        items.sort((s1,s2) -> s2.compareTo(s1));

//        items.forEach(System.out::println);
//        System.out.println(items);

        //-------------------------------------------------------------
//      Problem 5:
//        List<String> animals = new ArrayList<>(Arrays.asList("Cat", "Elephant", "Dog", "Horse"));
//        List<String> fiveLengthAninmals = animals.stream().filter(len -> len.length() >= 5).toList();

//        fiveLengthAninmals.forEach(System.out::println);

//       animals.removeIf(s -> s.length() >=5 );

//        System.out.println(animals);
//        int x = 10;
//        int y = 20;
//
//        MathOperation add = Integer::sum;
//
//        MathOperation sub = (n1,n2) -> n1-n2;
//        calculateAndPrint("Addition", x, y, add);
//        calculateAndPrint("Substraction", x, y, sub);
//
//        List<String> words = Arrays.asList("", "", "", "");
//
//
//
//        Optional<String> maxWord = words.stream().max((o1, o2) -> Integer.compare(o1.length(), o2.length()));


//        maxWord.ifPresent(word -> System.out.println("Longest word : "+word));
//        System.out.println(maxWord);
//        int maxLength = words.stream().mapToInt(String::length).max().orElse(0);
//        List<String> maxWords = words.stream().filter(w -> w.length()==maxLength).toList();

//        System.out.println(maxWords);
//        Optional<String> str = Optional.of("");
//        str.ifPresent(val -> System.out.println("Length: "+val.length()));
//
//
//        List<String> namess = Arrays.asList(" Amit        ", "Rahul", "Anita", "Sanjay");

//        List<String> n = namess.stream().filter(s1->s1.trim().startsWith("A")).toList();
//        System.out.println(n);
//-------------------------------------------Q1----------------------------------------------
        //Q1. Print List Using Lambda
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        //Solution :
//        fruits.forEach(System.out::println); // fruits.forEach(fruit -> System.out.println(fruit));

//-----------------------------------------------------------------------------------------

// -------------------------------------------Q2----------------------------------------------
        //Q.2 Filter Even Numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> even = numbers.stream().filter(n -> n % 2 != 0).toList();

//        System.out.println(even);

// -----------------------------------------------------------------------------------------

// -------------------------------------------Q3----------------------------------------------
//        Q3. Convert Strings to Uppercase
        List<String> names = Arrays.asList("john", "doe", "alice");
        List<String> nameUpperCase = names.stream().map(String::toUpperCase).toList();

        List<String> nameLowerCase = names.stream().map(s -> s.toLowerCase()).toList();

//        System.out.println("Upper Case Names : "+nameUpperCase);
//        System.out.println("Lower Case Names : "+nameLowerCase);
// -----------------------------------------------------------------------------------------

// -------------------------------------------Q4----------------------------------------------
        //Q4. Sort a List in Reverse Order
        List<String> items = Arrays.asList("Zebra", "Monkey", "Apple", "Mango");

//        items.sort((s1,s2)->s2.compareTo(s1));
        items.sort(Comparator.reverseOrder());
//        items.sort(Comparator.naturalOrder());
//        System.out.println(items);
// -----------------------------------------------------------------------------------------

// -------------------------------------------Q5----------------------------------------------
        //Q5 Remove Items with Length < 5
        List<String> animals = new ArrayList<>(Arrays.asList("Cat", "Elephant", "Dog", "Horse"));
        animals.removeIf(animal -> animal.length() < 5);

//        System.out.println(animals);
// -----------------------------------------------------------------------------------------

// -------------------------------------------Q6----------------------------------------------
        //Q7. Use Predicate to Filter Strings
        //Create a Predicate<String> to filter names that start with "A".
        List<String> naam = Arrays.asList("Amit", "Rahul", "Anita", "Sanjay");

        List<String> nameStartWithA = naam.stream().filter(s1 -> s1.startsWith("A")).toList();
//        System.out.println(nameStartWithA);

// -----------------------------------------------------------------------------------------


// -------------------------------------------Q7----------------------------------------------
//        8. Using Optional + Lambda
//        Problem: Given an optional string, print the length only if the value is present.
        Optional<String> str = Optional.of("");

//        str.ifPresent(s1 -> System.out.println("Length : " + s1.length()));


//        System.out.println(str.orElse("Rakmo"));

        Optional<String> optional = Optional.empty();
//        System.out.println("Using get " + optional.orElse("null"));

// -------------------------------------------Q8----------------------------------------------
//        Thread thread = new Thread(() -> System.out.println("Thread is Running"));



//        thread.start();
//        String threadName = thread.getName();
//        System.out.println(threadName);
// -----------------------------------------------------------------------------------------
        int a = 6;
        int b = 7;
//        System.out.println(String.format("%.6f",(double)a/b));

// -----------------------------------------------------------------------------------------

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omkar", new Address("Panvel", "Maharashtra", "India"), 79000.0,Arrays.asList("om@gmail.com","ram@gmail.com"),"IT"));
        employeeList.add(new Employee("Jayesh", new Address("pune", "Maharashtra", "India"), 54000.0,Arrays.asList("hari@gmail.com","shree@gmail.com"),"BA"));
        employeeList.add(new Employee("Gaurav", new Address("Mumbai", "Maharashtra", "USA"), 54000.0,Arrays.asList("jay@gmail.com","shiva@gmail.com"),"IT"));
        employeeList.add(new Employee("Akshay", new Address("Bhiwandi", "Maharashtra", "America"), 60000.0,Arrays.asList("gaurav@gmail.com","sanket@gmail.com"),"Cyber"));
//        employeeList.add(new Employee("Shraddha", new Address("Panvel", "Maharashtra", "Canada"), 80000,Arrays.asList("om@gmail.com","ram@gmail.com")));
//        employeeList.add(new Employee("Aboli", new Address("Panvel", "Maharashtra", "India"), 97000,Arrays.asList("om@gmail.com","ram@gmail.com")));
//        employeeList.add(new Employee("Apurva", new Address("Panvel", "Maharashtra", "New York"), 50000,Arrays.asList("om@gmail.com","ram@gmail.com")));

//        getEmployeeObjectList(employeeList);

//        List<Employee> filterEmp = employeeList.stream().filter(employee -> employee.getAddress().city == "Mumbai" && employee.salary > 22000).toList();
//
//        filterEmp.forEach(employee -> System.out.println(employee));

        // Grouping employees by names and sorting using set by override hashcode and equal method
//        Map<String, Set<Employee>> groupedByCountry =
//                employeeList
//                        .stream()
//                        .collect(Collectors.groupingBy(Employee::getName, TreeMap::new, Collectors.toSet()));
//        groupedByCountry.forEach((name, employeeListCountry) -> {
//            System.out.println("Name : " + name);
//            employeeListCountry.forEach(System.out::println);
//        });

        List<Employee> sortedBySalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

//        System.out.println(sortedBySalary);
// -----------------------------------------------------------------------------------------
        //Q. Find the duplicate elements in the List
        List<Integer> list = Arrays.asList(2, 1, 7, 1, 5, 5, 9);
//        Set<Integer> duplicate = new HashSet<>();
//        List<Integer> duplicateElements = list.stream().filter(x1 -> !duplicate.add(x1)).toList();
//        System.out.println(duplicateElements);

//        List<Integer> unique = list.stream().distinct().collect(Collectors.toList());

//        System.out.println(unique);

//        int sum = list.stream().reduce(0, Integer::sum);
//        System.out.println(sum);

        Stream<Integer> greaterThanFive =  list.stream().filter(n -> n > 5);

//        greaterThanFive.forEach(System.out::println);

        //----------When to use map and flatMap-------------------
//        System.out.println("Employee List : "+employeeList);
//        List<String> empName =  employeeList.stream().map(Employee::getName).toList();
//        List<Address> empAddress =  employeeList.stream().map(Employee::getAddress).toList();
//        System.out.println(empAddress);

        //Using simple map function
//            List<List<String>> empEmailUsingMap =  employeeList.stream().map(Employee::getEmail).toList();
//            System.out.println(empEmailUsingMap);
//            //Using  flatMap function
//            List<String> empEmailUsingFlatMap =  employeeList.stream().flatMap(email -> email.getEmail().stream()).toList();
//            System.out.println(empEmailUsingFlatMap);

        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
//        System.out.println(compareBySalary);
        Map<Double, Optional<Employee>> collect = employeeList.stream().
                collect(
                        Collectors.groupingBy(
                                Employee::getSalary, Collectors.reducing(BinaryOperator.maxBy(compareBySalary))
                        )
                );
//        System.out.println(collect);
//        IntStream.rangeClosed(1,20).forEach(t-> System.out.println( Thread.currentThread().getName() + " : " + t));
//        System.out.println("==========================================================");
//        IntStream.rangeClosed(1,10).parallel().forEach(t-> System.out.println( Thread.currentThread().getName() +  " : " + t));

        int i = Runtime.getRuntime().availableProcessors();
//        System.out.println(i);
        final int jj = 0;
        System.out.println(jj);
    }

    public static void calculateAndPrint(String operationName, int a, int b, MathOperation m) {
//        int result = m.opertator(a, b);
//        int sub = m.opertator(a, b);
//        System.out.println(operationName + " : " +result);
//        System.out.println(operationName + " : " +sub);

    }

    public Object getEmployeeObjectList(Employee empObj) {
        return empObj;
    }
}