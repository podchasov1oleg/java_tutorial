package homework7.marathon;

public class Wall implements Obstacle {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(int maxHeight) {
        return maxHeight >= this.height;
    }

    @Override
    public int getParameter() {
        return this.height;
    }
}
