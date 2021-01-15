package staff;

public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final int wage;
    private final byte age;

    public Employee(String name, String position, String email, String phone, int wage, byte age) {
        this.fullName = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.wage = wage;
        this.age = age;
    }

    public String toString() {
        return String.format(
            "Информация о сотруднике %s:\n Должность: %s\n E-mail: %s\n Телефон: %s\n Заработная плата: %s$\n Возраст: %s\n",
            this.fullName,
            this.position,
            this.email,
            this.phone,
            this.wage,
            this.age
        );
    }

    public byte getAge() {
        return this.age;
    }
}
