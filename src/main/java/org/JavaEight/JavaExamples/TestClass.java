package org.example.JavaExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class TestClass implements Comparator<TestClass> {
    int id;
    String name;
    String city;

    String getName(){
        return name;
    }

    public TestClass(int id,String name, String city){
        this.id=id;
        this.name=name;
        this.city=city;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        List<TestClass> studentList = new ArrayList<>();
        studentList.add(new TestClass(7,"Omkar","Panvel"));
        studentList.add(new TestClass(9,"Rakmo","Gorgaon"));
        studentList.add(new TestClass(5,"Gaurav","Andheri"));
        studentList.add(new TestClass(11,"Jayesh","Bhwandi"));
//
//        studentList.sort(Comparator.comparing(TestClass::getName));
        studentList.sort(Comparator.comparing(tc -> tc.name));

        studentList.forEach(System.out::println);
//        System.out.println(studentList);
    }

//    @Override
//    public int compareTo(TestClass tc) {
//        return this.id - tc.id;
//    }

    @Override
    public int compare(TestClass name1, TestClass name2) {
        return name1.name.compareTo(name2.name);
    }
}
