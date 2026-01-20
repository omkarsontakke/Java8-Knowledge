package org.JavaEight.JavaExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ThreadCreationUsingLambda {
    public static void main(String[] args) {
//        Runnable thread = () -> System.out.println("Thread Creation Done");
//        thread.run();

//        MathOperation mathOperation =  (i) -> System.out.println("Greeting from allied ..."+i);
//        mathOperation.print(14);

//        Function<Integer, String> function = (t) -> "Geeting Number : "+t;
//
//        System.out.println(function.apply(79));

//        Predicate<Integer> booleanPredicate = (num) -> num > 18;
//
//        System.out.println(booleanPredicate.test(19));

//        Consumer<String> stringConsumer = (str) -> System.out.println("Greeting Message from the : "+str);
//
//        stringConsumer.accept("Omkar Sontakke");

        Supplier<Integer> integerSupplier = () -> {
          return (int) (Math.random() * 1000) +1 ;
        };

        Integer value = integerSupplier.get();
//        System.out.println("Random Value from supplier : "+value);

        List<Integer> numList = Arrays.asList(5,3,7,1,0,9,8);

        List<Integer> newNumList = numList.stream().filter(n -> n>4).sorted(Integer::compareTo).toList();

//        System.out.println("Original List : "+numList);
//        System.out.println("--------------------------");
//        System.out.println("After performing task list : "+newNumList);



    }
}

