package questions;

/**
 * Проверка равенства строк, здесь происходит работа с пулом строк
 *
 * См. следующие ресурсы:
 * https://javadevblog.com/chto-takoe-pul-strok-v-java.html
 * https://ru.stackoverflow.com/questions/714949/%D0%A1%D1%80%D0%B0%D0%B2%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA-%D0%B2-java-%D0%BF%D0%BE-%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B5
 * https://ru.stackoverflow.com/questions/714982/%D0%9F%D0%BE-%D0%BA%D0%B0%D0%BA%D0%B8%D0%BC-%D0%BA%D1%80%D0%B8%D1%82%D0%B5%D1%80%D0%B8%D1%8F%D0%BC-%D0%B2-java-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0-%D0%BF%D0%BE%D0%BF%D0%B0%D0%B4%D0%B0%D0%B5%D1%82-%D0%B2-%D0%BF%D1%83%D0%BB-%D1%81%D1%82%D1%80%D0%BE%D0%BA
 */
public class StringPoolExamples {
    private static void test() {
        String a = new String("hello"),
               b = new String(a),
               c = a;
        char[] d = {'h','e','l','l','o'};

        boolean[] check = { a == "hello",  //false, ссылки на разные объекты в пуле строк
                            a == b,        //false, тоже ссылки на разные объекты
                            a == c,        //true, ссылка на один и от же объект
                            a.equals(b),   //true, содержимое объектов совпадает
                            a.equals(d),   //false, совершенно разные объекты

                            new String("a") == new String("a"),             //false, ссылки на разные объекты, находящиеся в куче
                            new String("aa") == new String("aa").intern(),  //false, ссылки на разные объекты, первый объект находится в куче, а второй интернирован и лежит в пуле
                            new String("aaa").intern() == new String("aaa").intern()  //true, интернированные строки ссылаются на один и тот же объект в пуле строк
        };

        for (boolean element : check) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
