import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentUser = "Customer";
        int currentCmd = 0;

        // Populate rooms for testing
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new StandardRoom(1, 1, 1, 100.5f, 4));
        rooms.add(new StandardRoom(2, 1, 2, 200.5f, 8));
        rooms.add(new DeluxeRoom(1, 2, 1, 300.5f, 120.6f, "Sea View"));
        rooms.add(new DeluxeRoom(2, 2, 2, 400.5f, 220.6f, "Landmark View"));
        rooms.add(new SuiteRoom(1, 3, 1, 500.5f, 130.8f, 2, true));
        rooms.add(new SuiteRoom(2, 3, 2, 600.5f, 230.8f, 4, false));

        System.out.println(rooms);

        // Looping of the application
        while (true) {
            System.out.println();
            System.out.println("Current User: " + currentUser);
            System.out.println();
            System.out.println("Please select an option:");

            if (currentUser == "Customer") {
                System.out.println("1. List all rooms.");
                System.out.println("2. Book a room.");
                System.out.println("3. Change to Admin Menu.");
                System.out.println("4. Exit the application.");

                System.out.print("Option: ");
                // Possible wrong inputs: alphabets (not integers), empty
                // Possible wrong inputs: space before num, space after num, negaive integers,
                // floats
                // If the input is incorrect, go to next iteration (do not break the iteration)
                // If the input is correct, do more operations

                String inputStr = scanner.nextLine();
                int returnInt = inputTest(1, inputStr, 1, 4);
                if (returnInt == -1) {
                    System.out.println("Wrong Input!");
                } else if (returnInt == 1) {

                }

            } else if (currentUser == "Admin") {
                System.out.println("1. List all rooms.");
                System.out.println("2. Add a room.");
                System.out.println("3. Change to Customer Menu.");
                System.out.println("4. Exit the application.");
            } else {
                System.out.println("ERROR: Wrong User!!!");
            }

        }
    }

    // Not to write valid input checks again and again
    // For integers, left and right are inclusive in the range
    // Made static to be able to called from main
    private static int inputTest(int inputType, String inputStr, int left, int right) {
        int inputInt;
        try {
            inputInt = Integer.parseInt(inputStr);
        } catch (Exception ex) {
            return -1;
        }

        if (inputInt >= left && inputInt <= right) {
            return inputInt;
        }else{
            return -1;
        }
    }

}
