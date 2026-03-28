import java.util.Scanner;

public class javatest2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("TATLO LANG NA NUMBERS INPUT MO: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

    
        if (num1 == num2 && num2 == num3) {
            System.out.println("PAREHONG NUMBER LAHAT LOKO!!");
        } 
        else {
            int largest = num1; 

            if (num2 > largest) {
                largest = num2;
            }
            
            if (num3 > largest) {
                largest = num3;
            }

            System.out.println("The largest number is: " + largest);
        }

        input.close();
    }
}
