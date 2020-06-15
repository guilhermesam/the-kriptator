import java.util.Scanner;

public class Kriptator {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int operation;

        do {
            System.out.println("Welcome to Kriptator v1.0.0 by Wabbajack");
            System.out.println("Select a operation: ");
            System.out.println("1: Caesar Cipher");
            System.out.println("2: Vigenere Cipher");
            operation = input.nextInt();

            if (operation == 1) {
                CaesarCipher caesar = new CaesarCipher();
                caesar.main();
            }

            else if (operation == 2) {
                VigereneCipher vigenere = new VigereneCipher();
                vigenere.main(); 
            }

            else {
                System.out.println("Invalid option, try again!");
            }
        } while (operation != 1 || operation != 2);

        input.close();
    }
}