import java.util.Scanner;



public class Calculator {
    public static final String VERSION = "1.0.0";

    public Calculator() {
    }

    public static void main(String[] args) {
        System.out.println();
        Scanner input = new Scanner(System.in);

        char choose;
        do {
            System.out.print("Enter first number: ");
            int num1 = input.nextInt();
            System.out.print("Enter second number: ");
            int num2 = input.nextInt();
            int sum = num1 + num2;
            System.out.println("Sum: " + sum);
            System.out.println();
            System.out.print("Do you want to exit? (y/n): ");
            choose = input.next().charAt(0);
        } while(choose != 'y' && choose != 'Y');

        System.out.println("Program exited. Thank you!");
        input.close();
        new Calculator();
    }

    public void printVersion() {
        System.out.println("Calculator Version: 1.0.0");
    }
}
