package utils;

import java.util.Random;

public class RandomGenerator {
    // Method generates random strings
    public String getRandomString(int wordLength) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < wordLength; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    // Method generates random numbers
    public int getRandomNumber(int length) {
        int number = (int) Math.pow(10, length - 1);
        return number + new Random().nextInt(9 * number);
    }

    // Method generates random boolean values
    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
