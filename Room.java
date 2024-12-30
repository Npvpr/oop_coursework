public class Room {
    private static int idCounter = 1;
    private int roomId, roomNumber, floor, occupancy;
    private double price;

    public Room() {

    }

    public Room(int roomNumber, int floor, int occupancy, double price) {
        this.roomId = idCounter++;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.occupancy = occupancy;
        this.price = price;
    }

    
    
    public int getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", floor=" + floor + ", occupancy=" + occupancy
                + ", price=" + price + "]";
    }

}