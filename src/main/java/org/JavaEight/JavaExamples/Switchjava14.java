package org.example.JavaExamples;

public class Switchjava14 {

    String name = "Omkar";

//    void demo(){
//        Runnable r = new Runable(){
//            String name = "AnnonymousName";
//
//        @Override
//        public void run(){
//            System.out.println("this.name = "+this.name);
//        }
//
//        };
//    }

   public static void main(String[] args) {

//    new Switchjava14.demo();


    int number = 4;

    String result  = switch (number) {
        case 5 -> {
            System.out.println("Matched 5 ");
            yield "Five";
        }
        case 6 -> {
            System.out.println("Matched 6 ");
            yield "Six";
        }
        case 7 -> {
            System.out.println("Matched 7 ");
            yield "Seven";
        }
        case 8 -> {
            System.out.println("Matched 8 ");
            yield "Eight";
        }
        default -> {
            System.out.println("Nothing Matched");
            yield "Nothing";
        }
    };

    System.out.println("Result from the switch case : "+result);

   } 
}