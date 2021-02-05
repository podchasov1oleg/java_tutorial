package homework10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.
        List<String> names = new ArrayList<>();
        names.add("Oliver");
        names.add("Jack");
        names.add("Harry");
        names.add("Jacob");
        names.add("Charley");
        names.add("Thomas");
        names.add("Jack");
        names.add("George");
        names.add("Oscar");
        names.add("James");
        names.add("William");
        names.add("Oliver");
        names.add("Harry");
        names.add("Jack");
        names.add("Jack");
        names.add("Oliver");

        Set<String> uniqueNames = new TreeSet<>(names);
        System.out.println(uniqueNames);

        for (String element : uniqueNames) {
            System.out.printf("Name \"%s\" occurs %d times in names list\n", element, Collections.frequency(names, element));
        }

        //2.
        Phonebook.add("Connor Sarah", "79999999999");
        Phonebook.add("Connor Sarah", "79999999998");
        Phonebook.add("Connor Sarah", "79999999997");
        Phonebook.add("Kyle Reese", "79999999996");
        Phonebook.add("Arnold Schwarzenegger", "79999999995");

        Phonebook.get("Connor Sarah");
        Phonebook.get("Arnold Schwarzenegger");
        Phonebook.get("John Connor");
    }
}
