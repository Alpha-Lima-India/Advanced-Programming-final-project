public class TicketSeller extends User {
//new Ticket(date, flightNumber, flightHour, capacity, origin, destination);

    public void addThicket(String date, int flightNumber, int flightHour, int capacity, String origin, String destination) {
        for (Ticket ticket : Ticket.tickets) {
            if (ticket.getflightNumber() == flightNumber) {
                System.out.println("Error: this flightnumber and ticket is already made. ");
            } else {
                Ticket ticket1 = new Ticket(date, flightNumber, flightHour, capacity, origin, destination);
            }
        }
    }

    public void cancelTicket(Ticket ticket) {
        if (Ticket.tickets.contains(ticket)) {
            Ticket.tickets.remove(ticket);
            System.out.println("flight number " + ticket.getflightNumber()+ " was canceled successfully. ");
        } else {
            System.out.println("Error: ticket doesnt exist.");
        }
    }

    public void changeFlightCapacity(Ticket ticket, int newFlightCapacity) {
        if (Ticket.tickets.contains(ticket)) {
            ticket.setRemaindCapacity(newFlightCapacity );
        } else {
            System.out.println("Error: ticket doesnt exist.");
        }
    }

}
