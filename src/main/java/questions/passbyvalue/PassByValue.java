package questions.passbyvalue;

/**
 * В данном классе доказывается, что в языке Java происходит передача по значению (pass-by-value), а не по ссылке (pass-by-reference)
 * По факту мы передаем ссылку, но на самом деле передается значение
 *
 * См. следующие ресурсы:
 * https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 */
public class PassByValue {

    //для примитивов значения никак не будут изменяться
    static void testForPrimitives(int i) {
        System.out.println("Passed value: i = " + i);  //1
        int x = i;
        System.out.println("Assigned the value i to x, x = " + x);  //1
        x++;
        i++;
        System.out.println("Increased x value, x = " + x +  //2
                         "\nIncreased i value, i = " + i);  //1
    }

    //если изменить ссылку для переданного (внешнего) объекта в методе, то это никак не скажется на внешней ссылке, переданной методу
    //внешняя ссылка продолжит ссылаться на первый объект
    static void testForObjects(Dog dog) {
        boolean check;

        check = dog.getName().equals("Kek");
        System.out.println("In testForObjects() equals Kek? " + check);
        check = dog.getName().equals("Lol");
        System.out.println("In testForObjects() equals Lol? " + check);

        dog = new Dog("Lol");

        check = dog.getName().equals("Lol");
        System.out.println("In testForObjects() after creating new Dog equals Lol? " + check);
    }

    //но если у объекта имеются сеттеры, то тогда возможно изменение переданного (внешнего) объекта
    //получается, что ссылка все также ссылается на первый объект, однако сам объект уже оказывается измененным
    static void testForObjectsWithSetting(Dog dog) {
        boolean check;

        check = dog.getName().equals("Kek");  //true
        System.out.println("In testForObjectsWithSetting() equals Kek? " + check);
        check = dog.getName().equals("Lol");  //false
        System.out.println("In testForObjectsWithSetting() equals Lol? " + check);

        dog.setName("Lol");
        check = dog.getName().equals("Lol");  //true
        System.out.println("In testForObjectsWithSetting() after setting name equals Lol? " + check);
    }

    public static void main(String[] args) {
        //примитивы
        int i = 1;
        testForPrimitives(i);
        System.out.println("The value i after method work: i = " + i + "\n");  //1

        //объекты
        boolean check;
        Dog dog = new Dog("Kek");

        testForObjects(dog);

        check = dog.getName().equals("Kek");  //true
        System.out.println("Equals Kek? " + check);
        check = dog.getName().equals("Lol");  //false
        System.out.println("Equals Lol? " + check + "\n");

        testForObjectsWithSetting(dog);

        check = dog.getName().equals("Kek");  //false
        System.out.println("Equals Kek? " + check);
        check = dog.getName().equals("Lol");  //true
        System.out.println("Equals Lol? " + check);
    }
}
