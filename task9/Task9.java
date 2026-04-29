import static java.lang.Math.*;

public class Task9 {

    public static int add(int a, int b) {
        return addExact(a, b);
    }

    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }

    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

    public static int divide(int a, int b) {
        return floorDiv(a, b);
    }

    public static void main(String[] args) {

        int a = 20;
        int b = 5;

        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division (floorDiv): " + divide(a, b));

        // extra demo values
        System.out.println("\nExtra Tests:");
        System.out.println("Addition: " + add(10, 7));
        System.out.println("Subtraction: " + subtract(50, 12));
        System.out.println("Multiplication: " + multiply(6, 9));
        System.out.println("Division: " + divide(100, 3));
    }
}