import java.util.ArrayList;

public class Customer extends User{
    private String phoneNumber;
    public ArrayList<Ticket> BookedThickets;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void showAllReservedThickets() {
        for (Ticket thicket : BookedThickets) {
            System.out.println("-------------------------");
            System.out.println(thicket.getflightNumber());
            System.out.println(thicket.getOrigin());
            System.out.println(thicket.getDestination());
            System.out.println(thicket.getDate());
            System.out.println(thicket.getflightHour());
            System.out.println(thicket.getRemaindCapacity());
        }
    }

    public void purchaseTicket(Ticket ticket) {
        if (this.BookedThickets.contains(ticket)) {
            System.out.println("this ticket is already booked.");
        } else {
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
