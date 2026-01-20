package org.JavaEight.JavaTheoryAndImpl;

public class AmozonPay implements UPIPayment{

    @Override
    public String doPayment(String source, String destination) {
        UPIPayment.datePattern("dd/MM/yyyy");
        if (source == null & destination == null) {
            return "Starting the payment";
        }

        return "Something went wrong";
    }



    public static void main(String[] args) {
//        AmozonPay amozonPay = new AmozonPay();

        UPIPayment upiPayment = ( source,  destination) -> {
            return "Calling from the Lambda Expreesion ";
        };
        System.out.println(upiPayment.doPayment("Something went wrong", "Something"));
    }
}
