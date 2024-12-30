public class SuiteRoom extends Room {
    private double livingAreaSize;
    private int noBaths;
    private boolean hasKitchenette;

    public SuiteRoom() {

    }

    public SuiteRoom(
            int roomNumber,
            int floor,
            int occupancy,
            double price,
            double livingAreaSize,
            int noBaths,
            boolean hasKitchenette) {

        super(roomNumber, floor, occupancy, price);
        this.livingAreaSize = livingAreaSize;
        this.noBaths = noBaths;
        this.hasKitchenette = hasKitchenette;
    }

    public double getLivingAreaSize() {
        return livingAreaSize;
    }

    public int getNoBaths() {
        return noBaths;
    }

    public boolean getHasKitchenette() {
        return hasKitchenette;
    }

    @Override
    public String toString() {
        return "SuitRoom [roomNumber=" + this.getRoomNumber() +
                ", floor=" + this.getFloor() +
                ", occupancy=" + this.getOccupancy() +
                ", price=" + this.getPrice() +
                ", livingAreaSize=" + livingAreaSize +
                ", noBaths=" + noBaths +
                ", hasKitchenette=" + hasKitchenette +
                "]";
    }
}
