package homework11;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    private ArrayList<E> volume;

    public Box(ArrayList<E> volume) {
        this.volume = volume;
    }

    public float getWeight() {
        float result = 0;
        for (E e : volume) {
            result += e.getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.001;
    }

    public void setVolume(ArrayList<E> volume) {
        this.volume = volume;
    }

    public ArrayList<E> getVolume() {
        return volume;
    }

    public void transferFruits(Box<E> box) {
        ArrayList<E> newVolume = new ArrayList<>(this.volume);
        newVolume.addAll(box.getVolume());

        box.setVolume(new ArrayList<>(newVolume));
        this.volume.clear();
    }

    public void addFruit(E fruit) {
        this.volume.add(fruit);
    }
}
