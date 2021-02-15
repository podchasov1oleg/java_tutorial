package homework13;

public class Monitor {
    private Car[] cars;

    public Monitor(Car[] cars) {
        this.cars = cars;
    }

    public boolean allAreReady() {
        boolean allReady = true;

        for (Car car : cars) {
            allReady = car.isReady() && allReady;
        }

        if (allReady) System.out.println("ANNOUNCEMENT >>> Race begin!");

        return allReady;
    }
    
    public void checkForWinner(Car car) {
        boolean noWinner = true;

        for (Car carElement : cars) {
            noWinner = !carElement.isFinished() && noWinner;
        }

        if (noWinner) System.out.println(car.getName() + " - WINS");

        car.setFinished(true);
    }
}
