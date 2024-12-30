import java.util.Date;

public interface HotelManager {
    void addRoom(Room room);
    void deleteRoom(int roomNumber, int floorNumber);
    void listRoomsByNumber();
    void listRoomsByFloor();
    void generateBookingReport(Date startDate, Date endDate);
}
