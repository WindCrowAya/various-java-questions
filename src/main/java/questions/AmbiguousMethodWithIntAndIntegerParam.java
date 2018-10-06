package questions;

/**
 * То же, что и AmbiguousMethodWithIntAndIntegerVarargsParam, но без varargs.
 * Ошибки компиляции не возникает, компилятор выбирает метод с наиболее конкретным параметром, т.е. с int.
 *
 * Также рассмотрены случаи как можно вызвать остальные варианты перегруженного метода
 */
public class AmbiguousMethodWithIntAndIntegerParam {
    public static String test(int a)     { return "int"; }
    public static String test(double a)  { return "double"; }
    public static String test(Integer a) { return "Integer"; }
    public static String test(Double a)  { return "Double"; }
    public static String test(Number a)  { return "Number"; }
    public static String test(Object a)  { return "Object"; }

    public static void main(String[] args) {
        String result;

        Number n = new Integer(1);
        result = test(n.intValue());
        System.out.println("Number n = new Integer(1) , n.intValue() : " + result);  //int
        result = test(n);
        System.out.println("Number n = new Integer(1) , n :  " + result);  //Number

        Integer x = new Integer(2);
        result = test(x);
        System.out.println("Integer x = new Integer(2) :     " + result);  //Integer

        Object obj = new Integer(3);
        result = test(obj);
        System.out.println("Object obj = new Integer(3) :    " + result);  //Object

        Integer x2 = null;
        result = test(x2);
        System.out.println("Integer x2 = null :              " + result);  //Integer

//        result = test(null);
//        System.out.println("Ref is null :                    " + result);  //Error:(47, 18) java: reference to test is ambiguous
        //both method test(java.lang.Integer) in questions.AmbiguousMethodWithIntAndIntegerParam and method test(java.lang.Double) in questions.AmbiguousMethodWithIntAndIntegerParam match
        //Если оставить методы с параметрами Integer и Double, то возникнет вышеописанная ошибка, поскольку конкретных вариантов два и компилятор не может выбрать подходящий
        //Если оставить, например, только Integer, то null-ссылка будет относиться к Integer, т.к. в данном случае выбирается самый конкретный вариант

        //Если оставить метод только с int-параметром, то возникнет ошибка:
        //Error:(38, 23) java: incompatible types: <nulltype> cannot be converted to int

        //Если оставить методы с параметрами int и double, то возникнет ошибка:
        //Error:(38, 18) java: no suitable method found for test(<nulltype>)
        //    method questions.AmbiguousMethodWithIntAndIntegerParam.test(int) is not applicable
        //      (argument mismatch; <nulltype> cannot be converted to int)
        //    method questions.AmbiguousMethodWithIntAndIntegerParam.test(double) is not applicable
        //      (argument mismatch; <nulltype> cannot be converted to double)
    }
}
