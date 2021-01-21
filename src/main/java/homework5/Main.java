package homework5;

public class Main {
    public static void main(String[] args) {
        Cat c1 = new Cat("Barsik"), c2 = new Cat("Murzik"), c3 = new Cat("Persik");
        Dog d1 = new Dog("Bigby"), d2 = new Dog("Rex"), d3 = new Dog("Shady");

        c1.run(100);
        c2.run(200);
        c3.run(250);

        c1.swim(100);
        c2.swim(1);
        c3.swim(10);

        d1.run(100);
        d2.run(500);
        d3.run(1000);

        d1.swim(10);
        d2.swim(5);
        d3.swim(20);

        System.out.println("Экземпляров класса Animal создано: " + Animal.counter);
    }
}
