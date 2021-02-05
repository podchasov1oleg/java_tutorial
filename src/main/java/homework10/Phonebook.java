package homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private static Map<String, List<String>> book = new HashMap<>();

    public static void add(String lastName, String phone) {
        book.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phone);
    }

    public static void get(String lastName) {
        List<String> found = book.get(lastName);
        if (found == null || found.isEmpty()) {
            System.out.printf("No phone numbers found upon request \"%s\"\n", lastName);
        } else {
            System.out.printf("The following phone numbers were found upon request \"%s\":\n", lastName);
            System.out.println(found);
        }

    }
}
