public class Task3 {
    public static void main(String[] args) {

        // Changed variables so all if conditions become true
        String a = new String("Wow!");
        String b = "Wow";
        String c = new String("Wow");
        String d = c;

        boolean b1 = a != b;              // true
        boolean b2 = d.equals(b + "");    // true
        boolean b3 = !c.equals(a);        // true

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }
    }
}