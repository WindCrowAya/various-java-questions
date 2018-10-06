package interview_examples;

/**
 * Конструктор класса не возвращает никакое значение
 */
public class ReturnInConstructor {
    private ReturnInConstructor() {
//        return this; //Error:(8, 16) java: incompatible types: unexpected return value
    }

    public static ReturnInConstructor get() {
        return new ReturnInConstructor();
    }

    public static void main(String[] args) {
        ReturnInConstructor r1 = get();
        ReturnInConstructor r2 = new ReturnInConstructor();
    }
}
