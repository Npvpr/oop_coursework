import java.util.Comparator;

public class RoomNumberComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        if (room1.getRoomNumber() < room2.getRoomNumber()) {
            return -1;
        } else if (room1.getRoomNumber() > room2.getRoomNumber()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
