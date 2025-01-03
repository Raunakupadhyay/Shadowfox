package shadowfox_intern_project;
import java.util.Scanner;

public class Enhanced_cosole_based_calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEnhanced Calculator");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic(scanner);
                    break;
                case 2:
                    scientificCalculations(scanner);
                    break;
                case 3:
                    unitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the calculator.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Basic Arithmetic Operations
    private static void basicArithmetic(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0)
                    System.out.println("Result: " + (num1 / num2));
                else
                    System.out.println("Error: Division by zero.");
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    // Scientific Calculations
    private static void scientificCalculations(Scanner scanner) {
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Choose an option: ");
        int sciChoice = scanner.nextInt();

        switch (sciChoice) {
            case 1:
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                if (num >= 0)
                    System.out.println("Square Root: " + Math.sqrt(num));
                else
                    System.out.println("Error: Negative number.");
                break;
            case 2:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Unit Conversions
    private static void unitConversions(Scanner scanner) {
        System.out.println("1. Temperature Conversion");
        System.out.println("2. Currency Conversion");
        System.out.print("Choose an option: ");
        int convChoice = scanner.nextInt();

        switch (convChoice) {
            case 1:
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.print("Choose an option: ");
                int tempChoice = scanner.nextInt();
                System.out.print("Enter temperature: ");
                double temp = scanner.nextDouble();

                if (tempChoice == 1) {
                    System.out.println("Fahrenheit: " + (temp * 9 / 5 + 32));
                } else if (tempChoice == 2) {
                    System.out.println("Celsius: " + ((temp - 32) * 5 / 9));
                } else {
                    System.out.println("Invalid choice.");
                }
                break;

            case 2:
                System.out.println("1. USD to INR");
                System.out.println("2. INR to USD");
                System.out.print("Choose an option: ");
                int currChoice = scanner.nextInt();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                double rate = 82.5; // Example rate

                if (currChoice == 1) {
                    System.out.println("INR: " + (amount * rate));
                } else if (currChoice == 2) {
                    System.out.println("USD: " + (amount / rate));
                } else {
                    System.out.println("Invalid choice.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
    
