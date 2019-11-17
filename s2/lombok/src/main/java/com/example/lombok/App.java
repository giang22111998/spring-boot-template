package com.example.lombok;

public class App {
    public static void main(String[] args) {
        Person person = new Person();
        person.setA(1);
        person.setB(2);
        System.out.println(person);

        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        String d = new String("hello");

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(d == c);

        boolean x = false;
        boolean y = false;

        if (x && y) {
            System.out.println("&&");
        } else if (x || y) {
            System.out.println("||");
        } else {
            System.out.println("<>");
        }
    }
}
