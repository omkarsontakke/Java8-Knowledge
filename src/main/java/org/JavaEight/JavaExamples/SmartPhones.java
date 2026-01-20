package org.JavaEight.JavaExamples;

public class SmartPhones {
    String phoneName;
    int price;

    public SmartPhones(String phoneName, int price) {
        this.phoneName = phoneName;
        this.price = price;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SmartPhones{" +
                "phoneName='" + phoneName + '\'' +
                ", price=" + price +
                '}';
    }
}
