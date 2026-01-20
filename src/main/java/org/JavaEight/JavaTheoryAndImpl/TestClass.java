package org.example.JavaTheoryAndImpl;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {



    public static void main(String[] args) {

        List<Integer> numbers =  Arrays.asList(2,6,1,8,5);

        TestClass testClassObj = new TestClass();

        //Using Static method when method is static
        numbers.stream().filter(number -> number % 2 == 0).forEach( TestClass::printElementsStatic);

        // Using Instead method when method is not an static
        numbers.stream().filter(number -> number % 2 == 0).forEach( testClassObj::printElementsNonStatic);

        List<Users> users = Stream.of(
                new Users("Omkar", 865723, Arrays.asList("om@gmail.com","Rakmo@gmail.com")),
                new Users("Rakmo", 865723, Arrays.asList("Rakmo@gmail.com","om@gmail.com"))).toList();


        List<String> collectNames = users.stream().map(Users::getName).toList();
        List<String> collectEmails = users.stream().flatMap(usersEmail -> usersEmail.getEmails().stream()).toList();

//        System.out.println("Users Names : "+ collectNames);  //Output:- Users Names : [Omkar, Rakmo]
//        System.out.println("User Emails : "+ collectEmails); //Output:- User Emails : [om@gmail.com, Rakmo@gmail.com, Rakmo@gmail.com, om@gmail.com]

        // Stream VS Parallel Stream

        IntStream.rangeClosed(1,10).forEach(t -> System.out.println(Thread.currentThread().getName() + " " + t));
        System.out.println("===================================");
        IntStream.rangeClosed(1,10).parallel().forEach(t -> System.out.println(Thread.currentThread().getName() + " " + t));


    }


    // When method is static
    public static void printElementsStatic(int i){
        System.out.println(i);
    }

    //When mwthod is not an static
    public void printElementsNonStatic(int i){
        System.out.println(i);
    }






}
