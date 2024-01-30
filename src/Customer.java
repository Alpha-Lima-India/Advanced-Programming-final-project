import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Customer extends User{
//    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    public ArrayList<Ticket> BookedThickets = new ArrayList<>();

//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }

    public Customer(String username, String password) {
        this.password = password;
        this.userName = username;
    }

    public Customer(String username, String password, String firstName, String lastName, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = username;
        this.password = password;
    }
    public void showAllReservedThickets() {
        for (Ticket thicket : BookedThickets) {
            System.out.println("-------------------------------------");
            System.out.println("FlightNumber is:   " + thicket.getflightNumber());
            System.out.println("Origin:   " + thicket.getOrigin());
            System.out.println("Destination:   " + thicket.getDestination());
            System.out.println("Flight Date:   " + thicket.getDate());
            System.out.println("Flight Hour:   " + thicket.getflightHour());
            System.out.println("Flight Capacity:   " + thicket.getRemaindCapacity() + "\n status : Reserved");
        }
    }
//if (Ticket.tickets.contains(ticket))
    public void purchaseTicket(Ticket ticket) {
        if (this.BookedThickets.contains(ticket)) {
            System.out.println("this ticket is already booked.");
        } else {
//            ticket.setPassengers(this);
            this.BookedThickets.add(ticket);
            ticket.setRemaindCapacity( ticket.getRemaindCapacity() - 1 );
            System.out.println("ticket booked successfully. ");
        }
    }

    public void cancelTicket(int flightnum) {
        boolean confirm = false;
        List<Ticket> copy = new ArrayList<>(this.BookedThickets);
        for (Ticket ticket : copy) {
            if (ticket.getflightNumber() == flightnum) {
//                ticket.removePassengers(this);
                this.BookedThickets.remove(ticket);
                ticket.setRemaindCapacity( ticket.getRemaindCapacity() + 1 );
                confirm = true;
                System.out.println("Ticket canceled successfully. hope to see you in future flights. ");
            }
        }
        if (!confirm) {
            System.out.println("This ticket has not been booked.");
        }
    }

    public void initilizeTheProfile(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
