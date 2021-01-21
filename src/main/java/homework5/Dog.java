package homework5;

public class Dog extends Animal {

    private static final int maxSwimDistance = 10;
    private static final int maxRunDistance  = 500;

    public Dog(String name) {
        super(name);
    }

    public void run(int distance) {
        super.run(distance, maxRunDistance);
    }

    public void swim(int distance) {
        super.swim(distance, maxSwimDistance);
    }
}
