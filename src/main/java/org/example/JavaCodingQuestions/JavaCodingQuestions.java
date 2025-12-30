package org.example.JavaCodingQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaCodingQuestions {
    public static void main(String[] args) {

// -----------------------------------------------------------------------------------------

        //Q. WAP using stream to find frequency of each character in given string.
        String question = "What is your name?";

        Map<String, Long> collect1 = Arrays.stream(question.split("")).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )

        );

        Map<String, Long> collect = Arrays.stream(question.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(collect);
        System.out.println(collect1);


//-----------------------------------------------------------------------------------------
    }
}
