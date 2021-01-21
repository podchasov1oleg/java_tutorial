package homework5;

public class Animal {
    static int counter = 0;

    private final String name;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public void run(int distance, int maxRunDistance) {
        if (distance <= maxRunDistance) {
            System.out.printf("%s пробежал %d метров\n", this.name, distance);
        } else {
            System.out.printf("%s не пробежит %d метров, его предел %d метров\n", this.name, distance, maxRunDistance);
        }
    }

    public void swim(int distance, int maxSwimDistance) {
        StringBuilder msg = new StringBuilder();
        if (distance <= maxSwimDistance) {
            msg.append(this.name).append(" проплыл ").append(distance).append(" метров");
        } else {
            msg.append(this.name).append(" не проплывет ").append(distance).append(" метров, ");
            if (maxSwimDistance == 0) {
                msg.append(this.name).append(" не умеет плавать");
            } else {
                msg.append("его предел - ").append(maxSwimDistance).append(" метров");
            }
        }
        System.out.println(msg.toString());
    }
}
