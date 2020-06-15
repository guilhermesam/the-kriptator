import java.util.Scanner;

public class VigereneCipher {
    
    public String[] generateTable() {
        String alphabetRoot = "abcdefghijklmnopqrstuvwxyz";
        String cipher[] = new String[26];

        for (int i=0; i < 26; i++) {
            String pt1 = alphabetRoot.substring(i, alphabetRoot.length());
            String pt2 = alphabetRoot.substring(0, i);
            String alphabetTarget = pt1.concat(pt2);
            cipher[i] = alphabetTarget;
            
        }

        return cipher;
    }

    private String switchAlphabetRoot(int times) {
        String alphabetRoot = "abcdefghijklmnopqrstuvwxyz";

        String pt1 = alphabetRoot.substring(times, alphabetRoot.length());
        String pt2 = alphabetRoot.substring(0, times);
        String alphabetTarget = pt1.concat(pt2);

        return alphabetTarget;
    }

    public String encrypt(String keyword, String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int x, y; 
        char[] encryptedMessage = new char[message.length()];

        for (int i=0; i < keyword.length(); i++) {
           x = alphabet.indexOf(keyword.charAt(i));
           y = alphabet.indexOf(message.charAt(i));
           encryptedMessage[i] = switchAlphabetRoot(y).charAt(x);
        }

        return new String(encryptedMessage);
    }

    public String decrypt(String keyword, String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] table = generateTable();
        int x,y=0;
        char[] encryptedMessage = new char[message.length()];

        for (int i=0; i < keyword.length(); i++) {
            x = alphabet.indexOf(keyword.charAt(i));
            
            for (int j=0; j<26; j++) {
                if (table[j].charAt(x) == message.charAt(i)) {
                    y = j;
                }
            }
            encryptedMessage[i] = switchAlphabetRoot(y).charAt(0);            
        }
        
        return new String(encryptedMessage);
    }

    public void main() {
        Scanner input = new Scanner(System.in);
        char options, proceed;
        String message, keyword;
        System.out.println("Welcome to Vigenere Cipher");

        do {
            do {
            System.out.println("Do you want to encrypt or decrypt?");
            System.out.println("D: Decrypt\nE: Encrypt");
            options = input.next().toUpperCase().charAt(0);
                if (options == 'D') {
                    System.out.println("Insert message");
                    message = input.next();
                    System.out.println("Insert keyword");
                    keyword = input.next();
                    System.out.println("Decrypted message: " + decrypt(keyword, message));
                }

                else if (options == 'E') {
                    System.out.println("Insert message");
                    message = input.next();
                    System.out.println("Insert keyword");
                    keyword = input.next();
                    System.out.println("Encrypted message: " + encrypt(keyword, message));
                }

                else {
                    System.out.println("Invalid Option, try again!\n");
                }
            } while (options != 'D' && options != 'E');

            System.out.println("Do you want to continue? y/n (default: n)");
            proceed = input.next().toUpperCase().charAt(0);

        } while(proceed == 'Y');

        input.close();
    }

    public static void main(String[] args) {
        VigereneCipher v = new VigereneCipher();
        v.main();
    }
}