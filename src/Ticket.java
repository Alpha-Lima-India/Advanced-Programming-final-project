import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ticket {

    private String date;
    private int flightNumber;
    public static ArrayList<Ticket> tickets = new ArrayList<>();
    private String flightHour;
    private String origin;
    private String destination;
    private int remaindCapacity;




    public Ticket(String date, int flightNumber, String flightHour, int capacity, String origin, String destination) {
        this.date = date;
        this.flightHour = flightHour;
        this.remaindCapacity = capacity;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public static Ticket getTicketByFlightNumber(int flightnum) {
        for (Ticket ticket : Ticket.tickets) {
            if (ticket.getFlightNumber() == flightnum) {
                return ticket;
            }
        }
        return null;
    }

    public static void listOfAllTickets() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = now.format(formatter);
        System.out.println(formatted);
        for (Ticket thicket : Ticket.tickets) {
            System.out.println("-------------------------------------");
            System.out.println("FlightNumber is:   " + thicket.getFlightNumber());
            System.out.println("Origin:          " + thicket.getOrigin());
            System.out.println("Destination:     " + thicket.getDestination());
            System.out.println("Flight Date:  " + thicket.getDate());
            System.out.println("Flight Hour:     " + thicket.getFlightHour());
            System.out.println("Flight Capacity:  " + thicket.getRemaindCapacity());
        }
    }

    public static void searchInTickets(String origin, String destination, String date) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = now.format(formatter);
        System.out.println(formatted);
        for (Ticket ticket : Ticket.tickets) {
            if (ticket.getOrigin().equals(origin) && ticket.getDestination().equals(destination) && ticket.getDate().equals(date) ) {
                System.out.println("-------------------------------------");
                System.out.println("FlightNumber is:   " + ticket.getFlightNumber());
                System.out.println("Origin:          " + ticket.getOrigin());
                System.out.println("Destination:     " + ticket.getDestination());
                System.out.println("Flight Date:  " + ticket.getDate());
                System.out.println("Flight Hour:     " + ticket.getFlightHour());
                System.out.println("Flight Capacity:  " + ticket.getRemaindCapacity());
            }
        }
    }


    public String getDate() {
        return this.date;
    }

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public String getFlightHour() {
        return this.flightHour;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getRemaindCapacity() {
        return remaindCapacity;
    }

    public void setRemaindCapacity(int newCapacity) {
        remaindCapacity = newCapacity;
    }
}
