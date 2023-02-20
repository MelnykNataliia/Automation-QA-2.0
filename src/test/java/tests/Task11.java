package tests;

import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

public class Task11 {

    @Test
    // Prints a randomly generated string to the console
    public void randomString() {
        RandomGenerator randomString = new RandomGenerator();
        System.out.println(randomString.getRandomString(5));
    }

    @Test
    // Prints a randomly generated number to the console
    public void randomNumber() {
        RandomGenerator randomNumber = new RandomGenerator();
        System.out.println(randomNumber.getRandomNumber(3));
    }

    @Test
    // Prints a randomly generated boolean value to the console
    public void randomBooleanValue() {
        RandomGenerator randomBoolean = new RandomGenerator();
        System.out.println(randomBoolean.getRandomBoolean());
    }
}