import java.util.Scanner;

public class CaesarCipher {

    /*
     * Julius Caesar used a system of cryptography, now known as Caesar Cipher,
     * which shifted each letter 2 places further through the alphabet (e.g. 'A'
     * shifts to 'C', 'R' shifts to 'T', etc.). At the end of the alphabet we wrap
     * around, that is 'Y' shifts to 'A'. We can, of course, try shifting by any
     * number.
     */

    private String switchAlphabetRoot(int times) {
        String alphabetRoot = "abcdefghijklmnopqrstuvwxyz";

        String pt1 = alphabetRoot.substring(times, alphabetRoot.length());
        String pt2 = alphabetRoot.substring(0, times);
        String alphabetTarget = pt1.concat(pt2);

        return alphabetTarget;
    }

    public String encrypt(String message, int times) {
        char messageEncryptedVector[] = new char[message.length()];
        String alphabetRoot = "abcdefghijklmnopqrstuvwxyz";
        String messageEncrypted;

        for (int i = 0; i < message.length(); i++) {
            int index = alphabetRoot.indexOf(message.charAt(i));
            messageEncryptedVector[i] = switchAlphabetRoot(times).charAt(index);
        }

        messageEncrypted = new String(messageEncryptedVector);
        return messageEncrypted;
    }

    //zyxwvutsrqponmlkjihgfedcab
    public StringBuffer decrypt(String cipher, int shift) {
        shift = 26 - shift;
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public void main() {
        
        Scanner input = new Scanner(System.in);
        String message;
        int times;
        char option, proceed;

        do {
            System.out.println("Caesar Cypher 1.0.0");
            
            do {
                System.out.println("How many shifties?");
                times = input.nextInt();
            }
            while (times > 26 || times < 0);
            
            System.out.println("Do you want to encrypt or decrypt?");
            System.out.println("D - Decrypt");
            System.out.println("E - Encrypt");
            option = input.next().toUpperCase().charAt(0);

            if (option == 'E') {
                System.out.println("Type a message without spaces: ");
                message = input.next();
                System.out.println("The message encrypted is: " + encrypt(message, times));
            }

            else if (option == 'D') {
                System.out.println("Type a message without spaces: ");
                message = input.next();
                System.out.println("The message decrypted is: " + decrypt(message, times));
            }

            else {
                System.err.println("Incorrect operation!");
            }

            System.out.println("Do you want to try again?");
            proceed = input.next().toUpperCase().charAt(0);
        }

        while(proceed == 'Y');
            input.close();
    }

    public static void main(String[] args) {
        CaesarCipher c = new CaesarCipher();
        c.main();
    }
}