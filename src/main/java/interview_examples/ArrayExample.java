package interview_examples;

import java.util.Arrays;

/**
 * Значения массива будут меняться, т.к. final указывает на один и тот же объект и на его содержимое никак не влияет.
 * А вот сделать так, чтобы ссылка стала ссылаться на другой объект, нельзя, из-за ключевого слова final.
 * */
public class ArrayExample {
    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 4, 5};  //если не указать final, то появится ошибка "Variable 'array' is accessed from within inner class, needs to be declared final"
                                              //см. https://ru.stackoverflow.com/questions/491452/final-%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D0%B0%D1%8F-%D0%B4%D0%BB%D1%8F-%D0%B0%D0%BD%D0%BE%D0%BD%D0%B8%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0
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
