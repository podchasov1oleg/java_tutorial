package homework7.marathon;

public class RunningTrack implements Obstacle {
    private final int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(int maxDistance) {
        return this.distance <= maxDistance;
    }

    @Override
    public int getParameter() {
        return this.distance;
    }
}
