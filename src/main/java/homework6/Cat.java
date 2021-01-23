package homework6;

public class Cat {
    private final int APPETITE = (int) (Math.random() * 10);
    private boolean isHungry = true;
    private final String NAME;

    public Cat(String NAME) {
        this.NAME = NAME;
    }

    public void feed(Plate plate) {
        plate.decreaseFood(this.APPETITE);
        this.setHungry(false);
    }

    public void setHungry(boolean hungry) {
        this.isHungry = hungry;
    }

    public String getName() {
        return this.NAME;
    }

    public boolean isHungry() {
        return this.isHungry;
    }

    public int getAppetite() {
        return this.APPETITE;
    }
}
