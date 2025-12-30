package org.example.JavaExamples;

public class ThisKeywordInLamda implements Printer,Scannerr {


    @Override
    public void connect(){
        Scannerr.super.connect();
    }

    // String name = "Omkar";

    // void demo(){
    //     Runnable r = () -> {
    //         String name = "AnnonymousName";

    //         System.out.println("this.name = "+this.name);

    //     };
    //     r.run();
    // }


     @Override
    public void print(){
        System.out.println("print method from the Printer");
    }

    @Override
    public void Scan(){
        System.out.println("print method from the Printer");
    }

    public static void main(String[] args) {
        // new ThisKeywordInLamda.demo();

        ThisKeywordInLamda inLamda = new ThisKeywordInLamda();

        inLamda.connect();

    }
}

interface Printer {
    void print();
    default void connect(){
        System.out.println("Printer connecting...");
    }
}

interface Scannerr {
    public void Scan();
    default void connect(){
        System.out.println("Scanner Connecting...");
    }
}
