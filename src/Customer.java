import java.util.ArrayList;

public class Customer extends User{
//    private String phoneNumber;
    public ArrayList<Ticket> BookedThickets;

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

    public void showAllReservedThickets() {
        for (Ticket thicket : BookedThickets) {
            System.out.println("-------------------------");
            System.out.println("FlightNumber is: " + thicket.getflightNumber());
            System.out.println("Origin " + thicket.getOrigin());
            System.out.println("Destination " + thicket.getDestination());
            System.out.println("Flight Date " + thicket.getDate());
            System.out.println("Flight Hour " + thicket.getflightHour());
            System.out.println("Flight Capacity " + thicket.getRemaindCapacity());
        }
    }

    public void purchaseTicket(Ticket ticket) {
        if (this.BookedThickets.contains(ticket)) {
            System.out.println("this ticket is already booked.");
        } else if (Ticket.tickets.contains(ticket)){
            ticket.setPassengers(this);
            this.BookedThickets.add(ticket);
            ticket.setRemaindCapacity( ticket.getRemaindCapacity() - 1 );
        }
    }

    public void cancelTicket(Ticket ticket) {
        if (this.BookedThickets.contains(ticket)) {
            ticket.removePassengers(this);
            this.BookedThickets.remove(ticket);
            ticket.setRemaindCapacity( ticket.getRemaindCapacity() + 1 );
        } else {
            System.out.println("This ticket has not been booked.");
        }
    }

}
