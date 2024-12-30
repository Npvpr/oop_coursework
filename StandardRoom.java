public class StandardRoom extends Room {
    private int noWindows;

    public StandardRoom() {

    }

    public StandardRoom(
            int roomNumber,
            int floor,
            int occupancy,
            double price,
            int noWindows) {

        super(roomNumber, floor, occupancy, price);
        this.noWindows = noWindows;
    }

    public int getNoWindows() {
        return noWindows;
    }

    @Override
    public String toString() {
        return "StandardRoom [roomNumber=" + this.getRoomNumber() +
                ", floor=" + this.getFloor() +
                ", occupancy=" + this.getOccupancy() +
                ", price=" + this.getPrice() +
                ", noWindows" + noWindows +
                "]";
    }
}
