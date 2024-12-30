public class DeluxeRoom extends Room {
    private double balconySize;
    private String view;

    public DeluxeRoom() {

    }

    public DeluxeRoom(
            int roomNumber,
            int floor,
            int occupancy,
            double price,
            double balconySize,
            String view) {

        super(roomNumber, floor, occupancy, price);
        this.balconySize = balconySize;
        this.view = view;
    }

    public double getBalconySize() {
        return balconySize;
    }

    public String getView() {
        return view;
    }

    @Override
    public String toString() {
        return "DeluxeRoom [roomNumber=" + this.getRoomNumber() +
                ", floor=" + this.getFloor() +
                ", occupancy=" + this.getOccupancy() +
                ", price=" + this.getPrice() +
                ", balconySize=" + balconySize +
                ", view=" + view +
                "]";
    }
}
