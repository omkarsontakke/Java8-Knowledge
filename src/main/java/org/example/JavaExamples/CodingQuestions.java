package org.example.JavaExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingQuestions {

    public static void main(String[] args) {
//        Q.1 WAP in stream to find frequency of each character in a given string

        String str = "Omkaroo";

        Map<String, Long> collect = Arrays.stream(str.toLowerCase().split("")).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );

        System.out.println(collect);


        // Program to grp cities based on the population
        List<EmpCities> empCities = Arrays.asList(
                new EmpCities(100,"Mumbai"),
                new EmpCities(85,"Hyderabad"),
                new EmpCities(25,"Pune"),
                new EmpCities(65,"Panvel"),
                new EmpCities(105,"Bengaluru"),
                new EmpCities(9,"Delhi")

        );

        Map<String, List<String>> collect1 = empCities.stream().collect(Collectors.groupingBy(
                city -> {
                    if (city.getCityPopulation() < 50) return "Small";
                    else if (city.getCityPopulation() < 70) return "Medium";
                    else if (city.getCityPopulation() <= 100) return "Large";
                    else return "Huge";
                },
                Collectors.mapping(EmpCities::getCityName, Collectors.toList())
        ));

//        System.out.println(empCities);
//        System.out.println(collect1);




        List<SmartPhones> smartPhonesList = Arrays.asList(
          new SmartPhones("Android Vivo V29",1),
          new SmartPhones("Android Samsung s23",1),
          new SmartPhones("iOS Apple 14PRO",7),
          new SmartPhones("Android Samsung s25",5),
          new SmartPhones("Android OnePlus 9R",7),
          new SmartPhones("iOS Apple 17PRO MAX",5)

        );


        Map<String, List<String>> groupOS = smartPhonesList.stream().collect(Collectors.groupingBy(
                key -> {
                    if (key.getPhoneName().startsWith("Android")) return "Android";
                    else return "iOS";
                },Collectors.mapping(SmartPhones::getPhoneName, Collectors.toList())
        ));

//        System.out.println(groupOS);


        Map<String, List<Integer>> groupPrice = smartPhonesList.stream().collect(Collectors.groupingBy(
                key -> {
                    if (key.getPrice() == 1) return "One";
                    else if (key.getPrice() == 5) return "Five";
                    else return "Seven";
                }, Collectors.mapping(SmartPhones::getPrice, Collectors.toList())
        ));

//        System.out.println(groupPrice);


        //Print the numbers that start with 1, Note list can contain null,

        List<Integer> startWithOne = Arrays.asList(0,12,1,43,22,11,92,null,2,5,13,null);

        List<Integer> filterList =  startWithOne.stream()
//                .filter(Objects::nonNull)
                .filter(n -> n!=null && n.toString().startsWith("1")).sorted()
                .toList();

        System.out.println(filterList);





    }
}
