import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (true) {
            System.out.print("Input between 1 and 10: ");
            input = scanner.nextInt();

            if (input >= 1 && input <= 10) {
                System.out.println("Correct Input");
            } else {
                System.out.println("Wrong Input");
            }
        }

    }

}
