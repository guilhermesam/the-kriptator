import java.util.Scanner;

public class Kriptator {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int operation;

        System.out.println("Welcome to Kriptator v1.0.0 by Wabbajack");

        do {
            System.out.println("Select a operation: ");
            System.out.println("1: Caesar Cipher");
            System.out.println("2: Vigenere Cipher");
            operation = input.nextInt();   

            if (operation == 1) {
                CaesarCipher caesar = new CaesarCipher();
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
                        System.out.println("The message encrypted is: " + caesar.encrypt(message, times));
                    }

                    else if (option == 'D') {
                        System.out.println("Type a message without spaces: ");
                        message = input.next();
                        System.out.println("The message decrypted is: " + caesar.decrypt(message, times));
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

            else if (operation == 2) {
                VigereneCipher vigenere = new VigereneCipher();
                vigenere.main(); 
            }

            else {
                System.out.println("Invalid option, try again!");
            }

        } while (operation != 1 && operation != 2);

        System.out.println("Farewell :)");
        input.close();
    }
}