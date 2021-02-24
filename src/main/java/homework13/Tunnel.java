package homework13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    static Semaphore semaphore = new Semaphore(Main.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " is waiting for the stage: " + description);
                System.out.println(c.getName() + " began stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " finished stage: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

