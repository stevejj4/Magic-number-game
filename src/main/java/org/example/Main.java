package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 🔹 2D array: each row represents a difficulty level
        int[][] magicNumbers = {
                {10, 20, 30},        // Level 1 (Easy)
                {40, 50, 60},        // Level 2 (Medium)
                {70, 80, 90, 100}    // Level 3 (Hard)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("🎯 Welcome to the Multi-Level Magic Number Game!");
        System.out.println("You have 3 attempts per level. Guess correctly to move up!");

        // 🔹 Looping through each level
        for (int level = 0; level < magicNumbers.length; level++) {
            System.out.println("\n--- Level " + (level + 1) + " ---");
            System.out.println("Guess a magic number!");

            int attempts = 0;
            boolean found = false;

            while (attempts < 3 && !found) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                // ✅ Checking if guess exists in the current level
                boolean inLevel = false;
                for (int num : magicNumbers[level]) {
                    if (num == guess) {
                        inLevel = true;
                        break;
                    }
                }

                if (inLevel) {
                    System.out.println("🎉 Well done! " + guess + " is a magic number!");
                    found = true;

                    // Move to next level automatically
                    if (level < magicNumbers.length - 1) {
                        System.out.println("⬆️  Moving to the next level!");
                    } else {
                        System.out.println("🏆 Congratulations! You’ve completed all levels!");
                    }

                } else {
                    attempts++;
                    if (attempts < 3) {
                        System.out.println("❌ Not a magic number, try again!");
                    } else {
                        System.out.println("😢 You’ve used all your tries at Level " + (level + 1));
                        System.out.print("Type 'retry' to replay this level or 'quit' to exit: ");
                        String choice = scanner.next().toLowerCase();

                        if (choice.equals("retry")) {
                            attempts = 0; // resetting attempts
                        } else if (choice.equals("quit")) {
                            System.out.println("👋 Game Over. Thanks for playing!");
                            return; // program exits
                        }
                    }
                }
            }
        }

        scanner.close();
    }
}
