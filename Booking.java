import java.time.LocalDate;

public class Booking implements Overlappable {
    private static int idCounter = 1; // to generate unique booking IDs
    private int bookingId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String customerName;
    private String customerSurname;
    private LocalDate dateOfBirth;
    private String contactDetails;

    public Booking(int roomId, LocalDate checkInDate, LocalDate checkOutDate, String customerName, String customerSurname,
            LocalDate dateOfBirth, String contactDetails) {
        this.bookingId = idCounter++;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.dateOfBirth = dateOfBirth;
        this.contactDetails = contactDetails;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public boolean overlaps(Booking other) {
        // add same day check out and check in
        return (this.checkInDate.isBefore(other.checkOutDate) && this.checkOutDate.isAfter(other.checkInDate));
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", checkInDate=" + checkInDate + ", checkOutDate="
                + checkOutDate + ", customerName=" + customerName + ", customerSurname=" + customerSurname
                + ", dateOfBirth=" + dateOfBirth + ", contactDetails=" + contactDetails + "]";
    }

}
