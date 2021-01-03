public class HomeWork1 {
    public static void main(String[] args) {
        //п.2
        byte byteVal = 127;
        short shortVal = 32767;
        int intVal = 2147483647;
        long longVal = 9223372036854775807L;
        char chVal = 'c';
        float floatVal = 1.1f;
        double doubleVal = Math.PI;
        String strVal = "Some random string";
        boolean boolVal = false;

        //п.3
        System.out.println(basicArithmetics(1.1f, 2.2f, 3.3f, 4.4f));

        //п.4
        System.out.println(inSecondDecade(7, 9)); // true
        System.out.println(inSecondDecade(10, 13)); // false

        //п.5
        isPositiveOrNegative(0);
        isPositiveOrNegative(1);
        isPositiveOrNegative(-1);

        //п.6
        System.out.println(isNegative(1));
        System.out.println(isNegative(-1));

        //п.7
        greetings("#USER_NAME#");

        //п.8
        isLeapYear(2000); //true
        isLeapYear(2100); //false
        isLeapYear(2021); //false
        isLeapYear(2024); //true
    }

    private static float basicArithmetics(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean inSecondDecade(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    private static void isPositiveOrNegative(int a) {
        System.out.println(a >= 0 ? "Positive" : "Negative");
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void greetings(String name) {
        System.out.println("Привет, " + name);
    }

    private static void isLeapYear(int year) {
        if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            System.out.println(year + " - високосный год");
        } else if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0) {
            System.out.println(year + " - невисокосный год");
        }
    }
}
