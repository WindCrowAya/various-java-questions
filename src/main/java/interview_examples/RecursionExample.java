package interview_examples;

/**
 * См. стек вызовов
 */
public class RecursionExample {
    public static void main(String[] args) {
        recur(99);
    }

    private static void recur(int a) {  //a=99 a=100 a=101 a=100
        if (a <= 100) {
            System.out.println("a=" + a);
            recur(++a);
            System.out.println("a=" + a);
        }
    }
}
