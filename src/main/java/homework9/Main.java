package homework9;

import java.sql.*;

public class Main {
    private static Connection connection;

    public static void main(String[] args) {
        Cat[] cats = {
            new Cat("Барсик", "Абиссинская", "Короткошерстная", "Египет"),
            new Cat("Мурзик", "Мейн-кун", "Длинношерстная", "США"),
            new Cat("Персик", "Персидкая", "Длинношерстная", "Иран"),
            new Cat("Царапка", "Шартрез", "Короткошерстная", "Франция"),
            new Cat("Матроскин", "Петерболд", "Лысая", "Россия"),
            new Cat("Пушистик", "Бирманская", "Длинношерстная", "Бирма"),
        };
        try {
            connect();
            Cat.createTable(connection);
            //создаем
            for (Cat cat : cats) {
                cat.create(connection);
            }
            //читаем
            for (Cat cat : cats) {
                System.out.println(cat.read(connection));
            }
            //обновляем
            for (Cat cat : cats) {
                cat.update(connection, "Name", "Type", "Fur", "Origin");
            }
            //убеждаемся, что обновилось
            for (Cat cat : cats) {
                System.out.println(cat.read(connection));
            }
            //Удаляем
            for (Cat cat : cats) {
                cat.delete(connection);
            }

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cats;");
            //не выведет ни одного => котов больше нет
            while (rs.next()) {
                System.out.printf("Cat %s, ID %s\n", rs.getString("name"), rs.getLong("ID"));
            }

            disconnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cat.db");
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }
}
