package homework13;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private final Monitor monitor;
    private boolean isReady = false;
    private boolean finished = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isReady() {
        return isReady;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Car(Race race, int speed, Monitor monitor) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant #" + CARS_COUNT;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is getting ready");
        getReady();

        for (int i = 0; i < race.getStages().size(); i++) {
            Stage stage = race.getStages().get(i);
            if (stage instanceof Tunnel) {
                try {
                    Tunnel.semaphore.acquire();
                    stage.go(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Tunnel.semaphore.release();
                }
            } else {
                stage.go(this);
            }
        }
        this.finished = true;
        this.monitor.checkForWinner(this);
    }

    private void getReady() {
        synchronized (monitor) {
            try {
                Thread.sleep(500 + (int)(Math.random() * 800));
                this.isReady = true;
                System.out.println(this.name + " is ready");
                while (!monitor.allAreReady()) {
                    this.monitor.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
