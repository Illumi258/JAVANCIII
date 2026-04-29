interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {

    @Override
    public boolean feed(boolean timeToEat) {
        // put gorilla food into cage
        if (timeToEat) {
            System.out.println("Gorilla is being fed.");
            return true;
        } else {
            System.out.println("Gorilla is not hungry right now.");
            return false;
        }
    }

    @Override
    public void groom() {
        // lather, rinse, repeat
        System.out.println("Gorilla is being groomed.");
    }

    @Override
    public void pet() {
        // pet at your own risk
        System.out.println("Warning: Petting a gorilla is dangerous!");
    }
}

public class Task16 {

    public static void main(String[] args) {

        Gorilla g = new Gorilla();

        g.feed(true);
        g.groom();
        g.pet();
    }
}