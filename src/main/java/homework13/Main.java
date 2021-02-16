package homework13;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ANNOUNCEMENT >>> Get ready!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Monitor monitor = new Monitor(cars);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), monitor);
        }

        Thread[] threads = new Thread[cars.length];

        for (int i = 0; i < cars.length; i++) {
            threads[i] = new Thread(cars[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ANNOUNCEMENT >>> Race end!");
    }
}
