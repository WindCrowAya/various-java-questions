package questions.passbyvalue;

/**
 * Вспомогательный класс для тестируемого класса PassByValue
 */
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog name = " + name;
    }
}
