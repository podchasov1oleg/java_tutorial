package homework6;

public class Plate {
    public static int foodEaten = 0;
    private int foodAmount = 0;

    public void fill() {
        this.foodAmount = 10;
    }

    public int getFoodAmount() {
        return this.foodAmount;
    }

    public void decreaseFood(int appetite) {
        this.foodAmount -= appetite;
        foodEaten += appetite;
    }
}
