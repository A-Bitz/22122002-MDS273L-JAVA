package LAB5;

// Using Scanner Class to Accpet Value from the user
import java.util.Scanner;

public class Encrypt{
    private static final char[][] PLAIN = {{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}};
    private static final char[][] CIPHER = {{'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'}};

//Main method of the program:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 'E' to encrypt a message or 'D' to decrypt a message.");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("E")) {
                System.out.print("Enter the message you want to encrypt: ");
                String message = scanner.nextLine();
                String encryptedMessage = encrypt(message);
                System.out.println("Encrypted message: " + encryptedMessage);
            } else if (choice.equals("D")) {
                System.out.print("Enter the message you want to decrypt: ");
                String message = scanner.nextLine();
                String decryptedMessage = decrypt(message);
                System.out.println("Decrypted message: " + decryptedMessage);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Method to Encrypt the user inputla message according to the given question :
    private static String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char letter : message.toCharArray()) {
            char encryptedLetter = getReplacementLetter(letter, PLAIN, CIPHER);
            encryptedMessage.append(encryptedLetter);
        }

        return encryptedMessage.toString();
    }
//Method to Decrypt the user inputla message according to the given question :
    private static String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char letter : message.toCharArray()) {
            char decryptedLetter = getReplacementLetter(letter, CIPHER, PLAIN);
            decryptedMessage.append(decryptedLetter);
        }

        return decryptedMessage.toString();
    }

    // Function to replace the characters in accordance with the CIPHER text.
    private static char getReplacementLetter(char letter, char[][] fromTable, char[][] toTable) {
        boolean isLowerCase = Character.isLowerCase(letter);
        letter = Character.toUpperCase(letter);

        for (int i = 0; i < fromTable[0].length; i++) {
            if (letter == fromTable[0][i]) {
                char replacementLetter = toTable[0][i];

                if (isLowerCase) {
                    replacementLetter = Character.toLowerCase(replacementLetter);
                }

                return replacementLetter;
            }
        }

        return letter;
    }
}
