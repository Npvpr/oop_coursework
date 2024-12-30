import java.util.Comparator;

public class FloorNumberComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        if (room1.getFloor() < room2.getFloor()) {
            return -1;
        } else if (room1.getFloor() > room2.getFloor()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
