package org.example;

import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nScientific Calculator Menu:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    double num = scanner.nextDouble();
                    try {
                        System.out.println("Square Root: " + squareRoot(num));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    int n = scanner.nextInt();
                    try {
                        System.out.println("Factorial: " + factorial(n));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    double logNum = scanner.nextDouble();
                    try {
                        System.out.println("Natural Logarithm: " + naturalLogarithm(logNum));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter base (x): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent (b): ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + powerFunction(base, exponent));
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Square root of negative number is not defined in real numbers.");
        }
        return Math.sqrt(num);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not defined.");
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double naturalLogarithm(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers.");
        }
        return Math.log(num);
    }

    public static double powerFunction(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

