package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] numbers = {20, 40, 50, 60, 70};
        Scanner scanner = new Scanner(System.in);
        int attempts = 0; // initializing the number of attempts
        boolean found = false;

        System.out.println("Welcome to the Magic number game");
        System.out.println("Guess a two digit number");

        while(attempts < 3 && !found) {
            System.out.println("Enter your guess");
            int guess = scanner.nextInt();

            // check if guess is in the array

            boolean inArray = false;
            for (int num : numbers) {
                if (num == guess) {
                    inArray = true;
                    break;
                }
            }

            if (inArray) {
                System.out.println("Well done " + guess + "is a magic number");
                found = true;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Not a magic number, please try again");
                } else {
                    System.out.println("You have used all tries, type quit");
                    String choice = scanner.next().toLowerCase();
                    if (choice.equals("Quit")) {
                        System.out.println("Game over");
                        break;
                    } else {
                        attempts = 0; // reset attempts if user retries
                    }

                }
            }
        }
    }
}