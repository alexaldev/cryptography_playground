package symmetric;

import java.util.HashMap;
import java.util.Map;

public class Caesar {

    static final int LATIN_LETTERS_COUNT = 26;

    public static String cipher(final String msg, final int offset) {

        final StringBuilder result = new StringBuilder();
        final char[] msgLetters = msg.toCharArray();

        for (final char letter : msgLetters) {
            if (letter == ' ') {
                // Skip
            } else {
                int letterAscii = letter - 'a';
                int cipheredLetterAscii = (letterAscii + offset) % LATIN_LETTERS_COUNT;
                char cipheredLetter = (char) ('a' + cipheredLetterAscii);
                result.append(cipheredLetter);
            }
        }
        return result.toString();
    }

    public static String decipher(final String msg, final int offset) {
        return cipher(msg, LATIN_LETTERS_COUNT- (offset % LATIN_LETTERS_COUNT));
    }

    public static Map<Integer, String> decipherWithAllCombinations(final String msg) {

        final Map<Integer, String> deciphered = new HashMap<>();
        for (int i = 0; i < LATIN_LETTERS_COUNT; i++) {
            deciphered.put(i, decipher(msg, i));
        }
        return deciphered;
    }

    public static void main(String[] args) {
        final String message = "Hello I am Alex, and I really want to leave this place as soon as possible";
        final String ciphered = cipher(message, 3);
        System.out.println("Ciphered message: " + ciphered);

        for (Map.Entry<Integer, String> entry : decipherWithAllCombinations(ciphered).entrySet()) {
            System.out.println(String.format("Deciphered with offset: %d : %s", entry.getKey(), entry.getValue()));
        }
    }
}