package questions;

/**
 * При передаче методу Integer-ссылки со значением null в метод с int... (или просто с int), генерируется NPE
 *
 * Выводы:
 * Integer i = null     -> int... и int --- (нельзя присваивать null примитивам)
 * Integer[] arr = null -> int...       --- (Integer[] не преобразуется в int[])
 * Integer[] arr = null -> Integer...   +++ (можно передавать null ссылки)
 * int[] arrInt = null  -> int...       +++ (можно передавать null ссылки)
 * int[] arrInt = null  -> Integer...   --- (int[] не преобразуется в Integer[])
 */
public class IntegerWithNullRefToMethodWithIntVarargs {
    static void test(int... i) {
        System.out.println("Success test!");
    }

    static void test2(int i) {
        System.out.println("Success test2!");
    }

    static void test3(Integer... i) {
        System.out.println("Success test3!");
    }

    public static void main(String[] args) {
        Integer i = null;
//        test(i);   //в обоих вариантах генерируется NPE
//        test2(i);

        Integer[] arr = null;
//        test(arr);  //required int[], found Integer[]
        test3(arr);

        int[] arrInt = null;
        test(arrInt);
//        test3(arrInt); //required Integer[], found int[]
    }
}
