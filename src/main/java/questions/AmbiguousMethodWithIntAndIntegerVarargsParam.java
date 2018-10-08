package questions;

/**
 * Происходит неоднозначный вызов метода, компилятор не понимает какой именно нужно использовать параметр: (int...) или (Integer...)
 *
 * Очевидно, что каждый из четырёх методов (int, Integer, Number, Object) является потеницально применимым для вызова test(int).
 * Задача компилятора в этом случае - выбрать наиболее специализированный метод.
 * В случае методов с переменным количеством аргументов компилятор рассматривает, как соотносятся базовые типы и выбирает из них наиболее узкий,
 * при этом тип фактического параметра не учитывается. Так, из типов Integer, Number, Object наиболее узким будет Integer.
 * Но примитивные типы не являются подтипами ссылочных типов, поэтому из типов int и Integer компилятор не может выбрать наиболее узкий и генерирует ошибку компиляции.
 */
public class AmbiguousMethodWithIntAndIntegerVarargsParam {
    public static void test(int... a)     { System.out.println("int"); }
    public static void test(float... a)   { System.out.println("float"); }
    public static void test(double... a)  { System.out.println("double"); }
    public static void test(Integer... a) { System.out.println("Integer"); }
    public static void test(Number... a)  { System.out.println("Number"); }
    public static void test(Double... a)  { System.out.println("Double"); }
    public static void test(Object... a)  { System.out.println("Object"); }

    public static void main(String[] args) {
        Number n = new Integer(1);
//        test(n.intValue());  //Error:(31, 9) java: reference to test is ambiguous
        //both method test(int...) in questions.AmbiguousMethodWithIntAndIntegerVarargsParam and method test(java.lang.Integer...)in questions.AmbiguousMethodWithIntAndIntegerVarargsParam match
        test(n);  //Number
        //Если оставить метод только с int-параметром и передать ему ссылку Number, то возникнет ошибка:
        //Error:(22, 9) java: method test in class questions.AmbiguousMethodWithIntAndIntegerVarargsParam cannot be applied to given types;
        //  required: int[]
        //  found: java.lang.Number
        //  reason: varargs mismatch; java.lang.Number cannot be converted to int
        //
        //Если оставить метод только с int-параметром и передать ему ссылку Integer, то программа выдает "int"
        //!Нельзя передавать в метод с параметром-примитивом объекты, которые не могут быть unboxed!

//        int i = 1;
//        Integer i = new Integer(1);
//        test(i);   //Ambiguous! int и Integer, в обоих случаях
//        Double d = new Double(2);
//        test(d);   //Ambiguous! double и Double
//        Double dd1 = new Double(2.0f);
//        test(dd1); //Ambiguous! double и Double

        //Если оставить методы с параметрами int и Number, то будет ambiguous error
//        Integer i1 = new Integer(4);
//        test(i1);  //Ambiguous! int и Number

        //следующие 4 примера иллюстрируют, что компилятор смотрит на тип ссылки, а не на тип содержимого
        int[] arrInt = {1, 2};
        test(arrInt);  //int

        int[] arrIntWithIntegers = { new Integer(1), new Integer(2) };// TODO: 08.10.2018 проверить какого типа элементы внутри массива
        test(arrIntWithIntegers);  //int

        Integer[] arrInteger = { new Integer(1), new Integer(2) };
        test(arrInteger);  //Integer

        Integer[] arrIntegerWithInts = {1, 2, 3};
        test(arrIntegerWithInts);  //Integer

        //далее рассматриваются варианты присвоения переменной
//        Double d1 = new Integer(1);  //разные типы
//        Double d2 = 1;  //разные типы
        Double d3 = 1d;
        Double d4 = 1.0;
        double d11 = new Integer(1);  //unboxing
        double d22 = 1;
        double d33 = 1d;
        double d44 = 1.0;
        double d55 = 1f;

        float f1 = 1;
//        float f2 = 1d;   //разные типы, справа double
//        float f3 = 1.0;  //разные типы, справа double
        float f4 = 1f;

//        test(d22);  //Ambiguous! double и Double

        //Если оставить методы с параметрами float и double и передать в метод double-примитив, то выбирается double
        //Если оставить метод только с параметром float, тогда сгенерируется ошибка:  required: float[], found double
//        test(d33);

        //Вопрос из собеседования
        //При передаче Integer-ссылке значение null и передаче его в метод c int...-параметром генерируется NPE
        //А если передать в метод с Integer...-параметром, то на экран выведется "Integer"
//        Integer x = null;
//        test(x);
    }
}
