package se.kth.iv1350.deppos.model;
import java.util.Random;


public class InheritanceRandom extends Random {

    /**
     * Prints the random integer generated.
     * @param maxBound The maximum bound of the random integer.
     */
    public void printRandomIntTimes2(int maxBound) {
        int randomInt = nextInt(maxBound);
        System.out.println(randomInt);
    }

    /**
     * Returns the random integer multiplied by 2.
     * @param maxBound The maximum bound of the random integer.
     * @return The random integer multiplied by 2.
     */
    @Override
    public int nextInt(int maxBound) {
        int randomInt = super.nextInt(maxBound);
        System.out.println("Generated random int: " + randomInt + ". Random int * 2: " + randomInt * 2);
        return randomInt * 2;
    }
 }
