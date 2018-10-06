package questions;

public class OverloadMethods {
    public static void add(int n, int m) {
        System.out.println("Int method");
        System.out.println(n + m);
    }

    public static void add(long n, long m) {
        System.out.println("Long method");
        System.out.println(n + m);
    }

    public static void method(String st) {
        System.out.println("from String method");
    }

    public static void method(Object obj) {
        System.out.println("from Object method");
    }

    public static void main(String[] args) {
        add(2, 3);
        method(null);
    }
}
