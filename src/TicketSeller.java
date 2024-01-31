public class TicketSeller extends User {

    private int idnumber;


    public TicketSeller(String username, String password, int idnumber) {
        this.userName = username;
        this.password = password;
        this.idnumber = idnumber;
    }

    public void addThicket(String date, int flightNumber, String flightHour, int capacity, String origin, String destination) {
        if (Ticket.getTicketByFlightNumber(flightNumber) == null) {
            Ticket ticket1 = new Ticket(date, flightNumber, flightHour, capacity, origin, destination);
            Ticket.tickets.add(ticket1);
            System.out.println("Ticket added successfully. ");
        } else {
            System.out.println("Error: this -flight number- is already made. please choose another one. ");
        }
    }

    public void cancelTicket(int flightnum) {

        if (Ticket.getTicketByFlightNumber(flightnum) != null) {
            Ticket.tickets.remove(Ticket.getTicketByFlightNumber(flightnum));
            System.out.println("ticket removed successfully. ");
        } else {
            System.out.println("This ticket does not exist. ");
        }
    }



    public void changeFlightCapacity(int flightnum, int newFlightCapacity) {
        boolean confirm = false;
        for (Ticket ticket : Ticket.tickets) {
            if (ticket.getFlightNumber() == flightnum) {
                ticket.setRemaindCapacity(newFlightCapacity);
                System.out.println("the new capacity of flight number " + flightnum + " is " + newFlightCapacity);
                confirm = true;
            }
        }
        if (!confirm) {
            System.out.println("Error: flight number does not exist. ");
        }
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }
}
