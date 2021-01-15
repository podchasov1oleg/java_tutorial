import staff.Employee;

public class Homework4 {
    public static void main(String[] args) {
        Employee[] devsTeam = new Employee[]{
            new Employee(
                "Алешкин Марк Сергеевич",
                "Тимлид",
                "aleshkin.mark@gmail.com",
                "79999999999",
                5000,
                (byte) 32),
            new Employee(
                "Козлов Сергей Львович",
                "Архитектор",
                "kozlovs@gmail.com",
                "79999999998",
                4000,
                (byte) 41),
            new Employee(
                "Артемьев Александр Петрович",
                "Разработчик",
                "artemev93@gmail.com",
                "79999999997",
                2000,
                (byte) 28),
            new Employee(
                "Алешина Алиса Олеговна",
                "Менеджер проекта",
                "aleshinaa@gmail.com",
                "79999999996",
                2000,
                (byte) 25),
            new Employee(
                "Мамонтов Виталий Валерьевич",
                "DevOps инженер",
                "mamontvv@gmail.com",
                "79999999995",
                3000,
                (byte) 42)
        };

        for (Employee employee : devsTeam) {
            if (employee.getAge() >= 40) System.out.println(employee.toString());
        }
    }
}
