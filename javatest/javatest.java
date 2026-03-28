import java.util.Scanner;

public class javatest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        int sum = 0;
 
        for (int i = 1; i <= n; i++) {
            sum += i;20
        }


        System.out.println("Sum of the first " + n + " positive integers: " + sum);
        
        input.close();
    }
}