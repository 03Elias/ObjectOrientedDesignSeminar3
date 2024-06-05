package se.kth.iv1350.deppos.model;
import java.util.Random;


public class InheritanceRandom extends Random {

    /**
     * Prints the random integer generated.
     * @param maxBound The maximum bound of the random integer.
     */
    public void printRandomIntTimes2(int maxBound) {
        int randomInt = nextInt(maxBound);
        System.out.println("InheritedRandom generated: " + randomInt);
    }

    /**
     * Returns the random integer multiplied by 2.
     * @param maxBound The maximum bound of the random integer.
     * @return The random integer multiplied by 2.
     */
    @Override
    private int nextInt(int maxBound) {
        int randomInt = super.nextInt(maxBound);
        System.out.println("This is the random integer: " + randomInt);
        System.out.println("This is the random integer * 2: " + randomInt * 2);
        return randomInt * 2;
    }
 }
