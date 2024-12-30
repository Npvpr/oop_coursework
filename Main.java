import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HotelSystem hotelSystem = new HotelSystem();
        String currentUser = "Customer";

        // Populate rooms for testing
        hotelSystem.addRoom(new StandardRoom(1, 1, 1, 100.5, 4));
        hotelSystem.addRoom(new StandardRoom(2, 1, 2, 200.5, 8));
        hotelSystem.addRoom(new DeluxeRoom(1, 2, 1, 300.5, 120.6, "Sea View"));
        hotelSystem.addRoom(new DeluxeRoom(2, 2, 2, 400.5, 220.6, "Landmark View"));
        hotelSystem.addRoom(new SuiteRoom(1, 3, 1, 500.5, 130.8, 2, true));
        hotelSystem.addRoom(new SuiteRoom(2, 3, 2, 600.5, 230.8, 4, false));

        // Populate bookings for testing
        hotelSystem.addBooking(new Booking(1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), "John", "Cena", LocalDate.of(1960, 1, 1), "Westminster"));
        hotelSystem.addBooking(new Booking(2, LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 12), "Peter", "Parker", LocalDate.of(1980, 2, 2), "Abbey Wood"));
        hotelSystem.addBooking(new Booking(3, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 14), "Tony", "Stark", LocalDate.of(1970, 3, 3), "Barking"));

        // Looping of the application
        while (true) {
            System.out.println();
            System.out.println("Current User: " + currentUser);
            System.out.println();
            System.out.println("Please select an option:");

            // Customer Menu
            if (currentUser == "Customer") {
                System.out.println(
                        "1. List all available rooms on a specified timeframe, sorted by price (lower price first)");
                System.out.println(
                        "2. List all available rooms on a specified timeframe that match a type (e.g., SuiteRoom) and occupancy (e.g., double)");
                System.out.println("3. Book a room in a specified timeframe");
                System.out.println("4. Delete an already booked room by providing the booking ID");
                System.out.println("5. Change to Admin Menu");
                System.out.println("6. Exit the application");

                System.out.print("Option: ");
                // taking input with nextInt can lead to program stopping errors
                // Possible wrong inputs: alphabets (not integers), empty, space before num,
                // space after num, negaive integers, floats
                // Check input with separate method
                String inputStr = scanner.nextLine();
                int inputInt = inputTest(1, inputStr, 1, 6);
                if (inputInt == -1) {
                    System.out.println("Wrong Input!");
                } else if (inputInt == 1) {

                } else if (inputInt == 3) {
                    hotelSystem.listRoomsByNumber();
                } else if (inputInt == 5) {
                    currentUser = "Admin";
                    System.out.println("Changed to Admin Menu!");
                } else if (inputInt == 6) {
                    return;
                } else {
                    // This case should never happen
                    System.out.println("Somehow still Wrong Input!");
                }

            }

            // Admin Menu
            else if (currentUser == "Admin") {
                System.out.println("1. Add a new room");
                System.out.println("2. Delete an existing room");
                System.out.println("3. List all rooms sorted by room numbers");
                System.out.println("4. List all rooms sorted by floor numbers");
                System.out.println("5. Generate booking report");
                System.out.println("6. Change to Customer Menu");
                System.out.println("7. Exit the application");

                System.out.print("Option: ");
                String inputStr = scanner.nextLine();
                int inputInt = inputTest(1, inputStr, 1, 7);
                if (inputInt == -1) {
                    System.out.println("Wrong Input!");
                } else if (inputInt == 1) {

                    int roomNumber, floorNumber, occupancy;
                    double price;

                    while (true) {
                        System.out.print("Enter the room number(1-99): ");
                        String roomNumberStr = scanner.nextLine();
                        roomNumber = inputTest(1, roomNumberStr, 1, 99);
                        if (roomNumber == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter the floor number(1-99): ");
                        String floorNumberStr = scanner.nextLine();
                        floorNumber = inputTest(1, floorNumberStr, 1, 99);
                        if (floorNumber == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter the occupancy(1-3): ");
                        String occupancyStr = scanner.nextLine();
                        occupancy = inputTest(1, occupancyStr, 1, 3);
                        if (occupancy == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter the price(1.00-9999.99): ");
                        String priceStr = scanner.nextLine();
                        price = inputTest(1.0, priceStr, 1.00, 9999.99);
                        if (price == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter the type of room(1.StandardRoom, 2.DeluxeRoom, 3.SuiteRoom): ");
                        String typeStr = scanner.nextLine();
                        int type = inputTest(1, typeStr, 1, 3);
                        if (type == -1) {

                            System.out.println("Wrong Input!");

                        } else if (type == 1) {

                            int noWindows;

                            while (true) {
                                System.out.print("Enter the number of windows(1-10): ");
                                String noWindowsStr = scanner.nextLine();
                                noWindows = inputTest(1, noWindowsStr, 1, 10);
                                if (noWindows == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    break;
                                }
                            }

                            hotelSystem.addRoom(new StandardRoom(roomNumber, floorNumber, occupancy, price, noWindows));
                            break;

                        } else if (type == 2) {

                            double balconySize;
                            String view = "";

                            while (true) {
                                System.out.print("Enter the balcony size(1.00-999.99): ");
                                String balconySizeStr = scanner.nextLine();
                                balconySize = inputTest(1.0, balconySizeStr, 1.00, 999.99);
                                if (balconySize == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    break;
                                }
                            }

                            while (true) {
                                System.out.print("Enter the view(1.Sea View, 2.Landmark View, 3.Mountain View): ");
                                String viewStr = scanner.nextLine();
                                int viewInt = inputTest(1, viewStr, 1, 3);
                                if (viewInt == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    if (viewInt == 1) {
                                        view = "Sea View";
                                    } else if (viewInt == 2) {
                                        view = "Landmark View";
                                    } else if (viewInt == 3) {
                                        view = "Mountain View";
                                    }
                                    break;
                                }
                            }

                            hotelSystem.addRoom(
                                    new DeluxeRoom(roomNumber, floorNumber, occupancy, price, balconySize, view));
                            break;
                        } else if (type == 3) {

                            double livingAreaSize;
                            int noBaths;
                            boolean hasKitchenette = false;

                            while (true) {
                                System.out.print("Enter the living area size(1.00-999.99): ");
                                String livingAreaSizeStr = scanner.nextLine();
                                livingAreaSize = inputTest(1.0, livingAreaSizeStr, 1.00, 999.99);
                                if (livingAreaSize == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    break;
                                }
                            }

                            while (true) {
                                System.out.print("Enter the number of baths(1-4): ");
                                String noBathsStr = scanner.nextLine();
                                noBaths = inputTest(1, noBathsStr, 1, 4);
                                if (noBaths == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    break;
                                }
                            }

                            while (true) {
                                System.out.print("Enter if the room has kitchenette(1.true, 2.false): ");
                                String hasKitchenetteStr = scanner.nextLine();
                                int hasKitchenetteInt = inputTest(1, hasKitchenetteStr, 1, 2);
                                if (hasKitchenetteInt == -1) {
                                    System.out.println("Wrong Input!");
                                } else {
                                    if (hasKitchenetteInt == 1) {
                                        hasKitchenette = true;
                                    } else if (hasKitchenetteInt == 2) {
                                        hasKitchenette = false;
                                    }
                                    break;
                                }
                            }

                            hotelSystem.addRoom(new SuiteRoom(roomNumber, floorNumber, occupancy, price, livingAreaSize,
                                    noBaths, hasKitchenette));
                            break;
                        }
                    }

                }else if(inputInt == 2){
                    int roomNumber, floorNumber;

                    while (true) {
                        System.out.print("Enter the room number(1-99): ");
                        String roomNumberStr = scanner.nextLine();
                        roomNumber = inputTest(1, roomNumberStr, 1, 99);
                        if (roomNumber == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter the floor number(1-99): ");
                        String floorNumberStr = scanner.nextLine();
                        floorNumber = inputTest(1, floorNumberStr, 1, 99);
                        if (floorNumber == -1) {
                            System.out.println("Wrong Input!");
                        } else {
                            break;
                        }
                    }

                    hotelSystem.deleteRoom(roomNumber, floorNumber);

                } else if (inputInt == 3) {
                    hotelSystem.listRoomsByNumber();
                }else if(inputInt == 4){
                    hotelSystem.listRoomsByFloor();
                } else if (inputInt == 6) {
                    currentUser = "Customer";
                    System.out.println("Changed to Customer Menu!");
                } else if (inputInt == 7) {
                    return;
                } else {
                    // This case should never happen
                    System.out.println("Somehow still Wrong Input!");
                }

            }

            // This case should never happen
            else {
                System.out.println("ERROR: Wrong User!!!");
            }
        }
    }

    // Not to write valid input checks again and again
    // left and right are inclusive in the range
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
        } else {
            return -1;
        }
    }

    private static double inputTest(double inputType, String inputStr, double left, double right) {
        double inputDouble;
        try {
            inputDouble = Double.parseDouble(inputStr);
        } catch (Exception ex) {
            return -1;
        }

        if (inputDouble >= left && inputDouble <= right) {
            return inputDouble;
        } else {
            return -1;
        }
    }
}
