package homework7.marathon;

public class Robot implements Runable, Jumpable, TestSubject {
    private final int MAX_DISTANCE = 200000;
    private final int MAX_HEIGHT = 10;
    private final String name;
    private boolean disqualified = false;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public void jump(Obstacle obstacle) {
        if (this.disqualified) {
            System.out.println(this.name + " дисквалифицирован");
            return;
        }

        if (obstacle.overcome(this.MAX_HEIGHT)) {
            System.out.println(this.name + " успешно перепрыгнул через стену высотой " + obstacle.getParameter());
        } else {
            System.out.println(this.name + " не смог перепрыгнуть через стену высотой " + obstacle.getParameter());
            this.disqualified = true;
        }
    }

    @Override
    public void run(Obstacle obstacle) {
        if (this.disqualified) {
            System.out.println(this.name + " дисквалифицирован");
            return;
        }

        if (obstacle.overcome(this.MAX_DISTANCE)) {
            System.out.println(this.name + " успешно пробежал дистанцию в " + obstacle.getParameter());
        } else {
            System.out.println(this.name + " не смог пробежать дистанцию в " + obstacle.getParameter());
            this.disqualified = true;
        }
    }
}
