package homework11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1.
        Integer[] ints = {0, 1, 2, 3 ,4};
        String[] strings = {"Ehal", "Greka", "cherez", "reku"};
        CatDemo[] cats = {
            new CatDemo("Murzik"),
            new CatDemo("Barsik"),
            new CatDemo("Persik"),
            new CatDemo("Tsarapka")
        };

        replaceArrayItems(ints, 1, 4);
        replaceArrayItems(strings, 1, 3);
        replaceArrayItems(cats, 2, 1);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));
        for (CatDemo cat : cats) {
            System.out.println(cat.getName());
        }

        //2.
        ArrayList<Integer> intsList = convertToList(ints);
        ArrayList<String> stringList = convertToList(strings);
        ArrayList<CatDemo> catsList = convertToList(cats);

        System.out.println(intsList);
        System.out.println(stringList);
        catsList.forEach((n) -> System.out.println(n.getName()));

        //3.
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 15; i++) apples.add(new Apple());

        ArrayList<Apple> apples2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) apples2.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<>();
        for (int i = 0; i < 25; i++) oranges.add(new Orange());

        ArrayList<Orange> oranges2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) oranges2.add(new Orange());
        //инициализация
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);
        Box<Orange> orangeBox2 = new Box<>(oranges2);
        Box<Apple> appleBox2 = new Box<>(apples2);
        //getWeight
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox2.getWeight());
        //compare
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(orangeBox2));
        System.out.println(orangeBox.compare(orangeBox2));
        //пересыпание фруктов
        appleBox.transferFruits(appleBox2);
        orangeBox2.transferFruits(orangeBox);
        //проверка веса коробок после пересыпания
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox2.getWeight());
        //добавление фруктов
        appleBox.addFruit(new Apple());
        orangeBox2.addFruit(new Orange());
        //проверка, что фрукты добавились
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox2.getWeight());
    }

    private static <T> void replaceArrayItems(T[] array, int index1, int index2) {
        if (index1 > array.length - 1 || index2 > array.length - 1) {
            System.out.println("Index is out of array range");
            return;
        }

        T copy = array[index1];
        array[index1] = array[index2];
        array[index2] = copy;
    }

    private static <T> ArrayList<T> convertToList(T[] a) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : a) {
            result.add(item);
        }
        return result;
    }

    static class CatDemo {
        String name;

        public CatDemo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
