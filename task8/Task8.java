public class Task8 {

    // returns total sum of all cumulative sums
    public static int computeCumulativeSums(int... numbers) {
        int totalSum = 0;

        for (int num : numbers) {
            int cumulative = 0;

            for (int i = 1; i <= num; i++) {
                cumulative += i;
            }

            System.out.println(num + " = " + cumulative);

            totalSum += cumulative;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int total = computeCumulativeSums(4, 5, 10);

        System.out.println("Total Sum of All = " + total);
    }
}