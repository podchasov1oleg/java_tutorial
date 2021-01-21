package homework5;

public class Cat extends Animal {

    private static final int maxSwimDistance = 0;
    private static final int maxRunDistance = 200;

    public Cat(String name) {
        super(name);
    }

    public void run(int distance) {
        super.run(distance, maxRunDistance);
    }

    public void swim(int distance) {
        super.swim(distance, maxSwimDistance);
    }
}
