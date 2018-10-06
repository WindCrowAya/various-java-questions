package questions;

/**
 *
 */
public class IntegerWithNullRefToMethodWithIntVarargs {
    static void test(int... i) {
        System.out.println("Success test!");
    }

    static void test2(int i) {
        System.out.println("Success test2!");
    }

    public static void main(String[] args) {
        Integer i = null;
        test(i);   //в обоих вариантах генерируется NPE
        test2(i);
    }
}
