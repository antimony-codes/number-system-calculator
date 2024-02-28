import java.math.BigInteger;
import java.util.Scanner;


public class Methods {
    public static String add(String num1, String num2, int base) {
        BigInteger b1 = new BigInteger(num1, base);
        BigInteger b2 = new BigInteger(num2, base);
        BigInteger result = b1.add(b2);
        return result.toString(base);
    }

    public static String subtract(String num1, String num2, int base) {
        BigInteger b1 = new BigInteger(num1, base);
        BigInteger b2 = new BigInteger(num2, base);
        BigInteger result = b1.subtract(b2);
        return result.toString(base);
    }

    public static String multiply(String num1, String num2, int base) {
        BigInteger b1 = new BigInteger(num1, base);
        BigInteger b2 = new BigInteger(num2, base);
        BigInteger result = b1.multiply(b2);
        return result.toString(base);
    }

    public static String divide(String num1, String num2, int base) {
        BigInteger b1 = new BigInteger(num1, base);
        BigInteger b2 = new BigInteger(num2, base);
        if (b2.equals(BigInteger.ZERO)) {
            return "Division by zero is not allowed.";
        }
        BigInteger result = b1.divide(b2);
        return result.toString(base);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            String num1 = scanner.next();

            System.out.print("Enter the second number: ");
            String num2 = scanner.next();

            System.out.print("Enter the base (2 for binary, 8 for octal, 16 for hexadecimal, 4 for quaternary): ");
            int base = scanner.nextInt();

            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();

            String result;
            switch (choice) {
                case 1 -> result = add(num1, num2, base);
                case 2 -> result = subtract(num1, num2, base);
                case 3 -> result = multiply(num1, num2, base);
                case 4 -> result = divide(num1, num2, base);
                default -> result = "Invalid choice.";
            }

            System.out.println("Result: " + result);
        }
    }
}