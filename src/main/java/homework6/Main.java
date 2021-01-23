package homework6;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[] {
            new Cat("Murzik"),
            new Cat("Barsik"),
            new Cat("Persik"),
            new Cat("Murka"),
            new Cat("Tsarapka"),
        };
        Plate plate = new Plate();
        plate.fill();

        introduceCats(cats);

        feedCats(cats, plate);
    }

    private static void introduceCats(Cat[] cats) {
        for (Cat cat : cats) {
            System.out.printf("У кота %s аппетит %d еды\n", cat.getName(), cat.getAppetite());
        }
    }

    private static void feedCats(Cat[] cats, Plate plate) {
        int iteration = 1;
        while (anyCatHungry(cats)) {
            for (Cat cat : cats) {
                if (cat.isHungry() && plate.getFoodAmount() >= cat.getAppetite()) {
                    cat.feed(plate);
                }
            }
            printStatus(cats, iteration++);
            plate.fill();
        }
        System.out.println("Все коты накормлены.");
        System.out.println("Всего итераций кормления: " + (iteration - 1));
        System.out.println("Всего съедено еды: " + Plate.foodEaten);
    }

    private static boolean anyCatHungry(Cat[] cats) {
        for (Cat cat : cats) {
            if (cat.isHungry()) return true;
        }

        return false;
    }

    private static void printStatus(Cat[] cats, int i) {
        System.out.println("Статус котов за " + i + " итерацию кормления:");
        for (Cat cat : cats) {
            System.out.println("Кот " + cat.getName() + (cat.isHungry() ? " голоден" : " не голоден"));
        }
        System.out.println("Миска снова наполнена.");
    }
}
