package basic_questions;

/**
 * При передаче в метод с параметром int ссылку на объект Integer, равный null, генерируется NPE
 *
 * См. следующие ресурсы:
 * https://stackoverflow.com/questions/2254435/can-an-int-be-null-in-java
 * */
public class IntegerEqualsNullToIntMethod {

    static void test(int i) {
        System.out.println("Success!");
    }

    public static void main(String[] args) {
        Integer i = null;
//      int i1 = null;  //нельзя присваивать null ссылке на примитив, можно только ссылкам на объекты
        test(i);  //IDEA: Unboxing of 'i' may produce 'java.lang.NullPointerException'; здесь возникает NPE
    }
}
