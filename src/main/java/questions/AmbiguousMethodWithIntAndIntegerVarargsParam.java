package questions;

/**
 * Происходит неоднозначный вызов метода, компилятор не понимает какой именно нужно использовать параметр: (int...) или (Integer...)
 *
 * Очевидно, что каждый из четырёх методов является потеницально применимым для вызова test(int).
 * Задача компилятора в этом случае - выбрать наиболее специализированный метод.
 * В случае методов с переменным количеством аргументов компилятор рассматривает, как соотносятся базовые типы и выбирает из них наиболее узкий,
 * при этом тип фактического параметра не учитывается. Так, из типов Integer, Number, Object наиболее узким будет Integer.
 * Но примитивные типы не являются подтипами ссылочных типов, поэтому из типов int и Integer компилятор не может выбрать наиболее узкий и генерирует ошибку компиляции.
 */
public class AmbiguousMethodWithIntAndIntegerVarargsParam {
    public static void test(int... a) {
        System.out.println("int");
    }

    public static void test(Integer... a) {
        System.out.println("Integer");
    }

    public static void test(Number... a) {
        System.out.println("Number");
    }

    public static void test(Object... a) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        Number n = new Integer(1);
//        test(n.intValue());  //Error:(31, 9) java: reference to test is ambiguous
        //both method test(int...) in questions.AmbiguousMethodWithIntAndIntegerVarargsParam and method test(java.lang.Integer...)in questions.AmbiguousMethodWithIntAndIntegerVarargsParam match
    }
}
