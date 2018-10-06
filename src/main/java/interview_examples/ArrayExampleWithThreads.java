package interview_examples;

import java.util.Arrays;

/**
 * То же, что и ArrayExample, но с потоками
 */
public class ArrayExampleWithThreads {  // TODO: 06.10.2018 сделать два потока
    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 4, 5};  //в одном потоке выполняется test(), в другом значение второго элемента массива умножается на 5
        new Object() {
            void test() {
                for (int i = 0; i < array.length; i++) {
                    array[i] *= 2;
                }
            }
        }.test();
        System.out.println(Arrays.toString(array));  //2 4 6 8 10
    }
}
