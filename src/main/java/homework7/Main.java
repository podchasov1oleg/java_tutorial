package homework7;

import homework7.marathon.*;

public class Main {
    public static void main(String[] args) {
        //П. 1-4
        Obstacle[] obstacles = new Obstacle[]{
                new Wall(2),
                new Wall(3),
                new Wall(5),
                new Wall(10),
                new RunningTrack(100),
                new RunningTrack(10000),
                new RunningTrack(40000),
                new RunningTrack(100000),
                new RunningTrack(250000),
                new RunningTrack(40000000),
        };

        TestSubject[] testSubjects = new TestSubject[]{
                new Cat("Simon's cat"),
                new Human("Harry Seldon"),
                new Robot("R. Daneel Olivaw")
        };

        for (Obstacle obstacle : obstacles) {
            for (TestSubject testSubject : testSubjects) {
                if (obstacle instanceof RunningTrack) {
                    testSubject.run(obstacle);
                } else {
                    testSubject.jump(obstacle);
                }
            }
            System.out.println("");
        }

        //п. 5-7
        String[][] valid = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalid1 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"17", "18", "18", "19"}
        };
        String[][] invalid2 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "a", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };
        int result;
        try {
            result = checkArrayIs4x4(valid);
            System.out.println("Result for array1: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            result = checkArrayIs4x4(invalid1);
            System.out.println("Result for array2: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            result = checkArrayIs4x4(invalid2);
            System.out.println("Result for array3: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int checkArrayIs4x4(String[][] array) {
        int sum = 0;
        if (array.length == 4) {
            for (String[] element : array) {
                if (element.length != 4) {
                    throw new MyArraySizeException("Invalid array size");
                } else {
                    for (String e : element) {
                        sum += tryParse(e);
                    }
                }
            }
        } else {
            throw new MyArraySizeException("Invalid array size");
        }

        return sum;
    }

    private static int tryParse(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Cannot parse string " + text);
        }

        return result;
    }
}
