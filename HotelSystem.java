import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelSystem implements HotelManager {

    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    private boolean isRoomExist(int roomNumber, int floorNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.getFloor() == floorNumber) {
                return true;
            }
        }
        return false;
    }

    public void addRoom(Room room) {
        int roomNumber = room.getRoomNumber();
        int floorNumber = room.getFloor();
        if (isRoomExist(roomNumber, floorNumber)) {
            System.out.println("Room already exists!");
        } else {
            rooms.add(room);
            System.out.println("Room added successfully!");
        }
    }

    public void deleteRoom(int roomNumber, int floorNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.getFloor() == floorNumber) {
                rooms.remove(room);
                System.out.println("Room deleted successfully!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    public void listRoomsByNumber() {
        Collections.sort(rooms, new RoomNumberComparator());
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void listRoomsByFloor() {
        Collections.sort(rooms, new FloorNumberComparator());
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void generateBookingReport(Date startDate, Date endDate) {
        System.out.println();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
