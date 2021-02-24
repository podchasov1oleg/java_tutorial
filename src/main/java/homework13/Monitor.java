package homework13;

public class Monitor {
    private Car[] cars;
    private boolean beginAnnounced = false;

    public Monitor(Car[] cars) {
        this.cars = cars;
    }

    public boolean allAreReady() {
        boolean allReady = true;

        for (Car car : cars) {
            allReady = car.isReady() && allReady;
        }

        if (allReady && !this.beginAnnounced) {
            System.out.println("ANNOUNCEMENT >>> Race begin!");
            this.notifyAll();
            this.beginAnnounced = true;
        }
        return allReady;
    }

    public void checkForWinner(Car car) {
        int finishedCnt = 0;

        for (Car carElement : cars) {
            if (carElement.isFinished()) finishedCnt++;
        }

        if (finishedCnt == 1) System.out.println(car.getName() + " - WINS");
    }
}