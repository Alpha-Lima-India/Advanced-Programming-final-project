import java.util.ArrayList;
import java.util.Scanner;

public class User {
    protected String userName;
    protected String password;

}

//    User newUser = null;
//        if (usertype.equals("TicketSeller")) {
//        for (int i : UserManager.idnumbers) {
//            if (i == idnumber) {
//                newUser = new TicketSeller(username, password, idnumber);
//                System.out.println("SignUp Done. ");
//                FileWriter listofallusers = new FileWriter("listofallusers.txt");
//                listofallusers.write(username + " " + password + " " + idnumber);
//                ListOfAllUsers.add(newUser);
//                return true;
//            }
//        }
//        System.out.println("the id number is not correct. ");
//        return false;
//    } else if (usertype.equals("Customer")) {
//        newUser = new Customer(username, password);
//        ListOfAllUsers.add(newUser);
//        System.out.println("SignUp Done. ");
//        return true;
//    } else {
//        newUser = null;
//        System.out.println("Invalid user type.");
//        return false;
//    }
//import java.util.ArrayList;
//        import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("welcome. Please Sign up or if you have signed up already log in now. ");
//        String command = "";
//        User inAppUser = null;
//
//
//        while (!command.equals("exit")) {
//
//            command = scanner.nextLine();
//            // sign up
//            if (command.equals("sign up")) {
//                int idnumber = 0;
//                System.out.println("please enter your usertype: ");
//                String Usertype = scanner.nextLine();
//                System.out.println("please enter your username: ");
//                String username = scanner.nextLine();
//                System.out.println("please enter your password: ");
//                String password = scanner.nextLine();
//                if (Usertype.equals("TicketSeller")) {
//                    System.out.println("please enter your idnumber: ");
//                    idnumber = scanner.nextInt();
//                }
//                boolean finalsign = UserManager.SignUp(username,password,Usertype,idnumber);
//                if (!finalsign) {
//                    System.out.println("sign up not successful. please sign up again. ");
//                } else {
//                    System.out.println("well done. now you should log in to enter. ");
//                }
//            }
//
//            // log in
//            else if (command.equals("log in")) {
//                System.out.println("please enter your username: ");
//                String username = scanner.nextLine();
//                System.out.println("please enter your password");
//                String password = scanner.nextLine();
//                User user = UserManager.login(username, password);
//                if (user != null) {
//                    System.out.println("well done. now you can use the program. ");
//                    inAppUser = user;
//                } else {
//                    System.out.println("if you dont have an account you should sign up first. use -sign up- command. ");
//                }
//            }
//
//            // commands for a possible costumer :
//            // 1. showAllReservedThickets
//            // 2. purchaseTicket
//            // 3. cancelTicket
//
//            // 1. showAllReservedThickets
//            else if (command.equals("showAllReservedThickets")) {
//                if (inAppUser instanceof Customer) {
//                    ((Customer) inAppUser).showAllReservedThickets();
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Costumer- and you cant use this command.");
//                }
//            }
//
//            // 2. purchaseTicket
//            else if (command.equals("purchaseTicket")) {
//                if (inAppUser instanceof Customer) {
//                    System.out.println("enter the -flight number- ticket that you want to book: ");
//                    int flightnum = scanner.nextInt();
//                    boolean confirm = false;
//                    for (Ticket ticket : Ticket.tickets) {
//                        if (ticket.getflightNumber() == flightnum) {
//                            ((Customer) inAppUser).purchaseTicket(ticket);
//                            confirm = true;
//                        }
//                    }
//                    if (!confirm) {
//                        System.out.println("wrong flight number. ");
//                    }
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Costumer- and you cant use this command.");
//                }
//            }
//
//            // 3. cancelTicket
//            else if (command.equals("cancelTicket")) {
//                if (inAppUser instanceof Customer) {
//                    System.out.println("enter the -flight number- that you want to cancel: ");
//                    int flightnum = scanner.nextInt();
//                    ((Customer) inAppUser).cancelTicket(flightnum);
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Costumer- and you cant use this command.");
//                }
//            }
//
//            // commands for both :
//            // 1. listOfAllTickets
//            // 2. searchInTickets
//
//            // 1. listOfAllTickets
//            else if (command.equals("listOfAllTickets")) {
//                if (inAppUser instanceof Customer || inAppUser instanceof TicketSeller) {
//                    Ticket.listOfAllTickets();
//                } else {
//                    System.out.println("sign up/log in first. ");
//                }
//            }
//
//            // 2. searchInTickets
//            else if (command.equals("searchInTickets")) {
//                if (inAppUser != null) {
//                    System.out.println("Enter your origin: ");
//                    String origin = scanner.nextLine();
//                    System.out.println("Enter your destination: ");
//                    String destination = scanner.nextLine();
//                    System.out.println("Enter a date: ");
//                    String date = scanner.nextLine();
//                    Ticket.searchInTickets(origin, destination, date);
//                } else {
//                    System.out.println("sign up/log in first. ");
//                }
//            }
//
//            // commands for a possible Ticket seller :
//            // 1. addThicket
//            // 2. cancelTicket
//            // 3. changeFlightCapacity
//
//            // 1. addThicket
//            else if (command.equals("addThicket")) {
//                if (inAppUser instanceof TicketSeller) {
//                    System.out.println("Enter the date, flightNumber, flightHour, capacity, origin and destination of the flight " +
//                            "in one line in order and split them by one space. ");
//                    String[] inputs = scanner.nextLine().split(" ");
//                    ((TicketSeller) inAppUser).addThicket(inputs[0], Integer.parseInt(inputs[1]), inputs[2], Integer.parseInt(inputs[3]), inputs[4], inputs[5]);
//                    //System.out.println("Ticket added.");
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Ticket seller- and you cant use this command.");
//                }
//            }
//
//            // 2. cancelflight
//            else if (command.equals("cancelflight")) {
//                if (inAppUser instanceof TicketSeller) {
//                    System.out.println("please Enter the flight number that you want to cancel: ");
//                    int numberOfFlight = scanner.nextInt();
//                    ((TicketSeller) inAppUser).cancelTicket(numberOfFlight);
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Ticketseller- and you cant use this command.");
//                }
//            }
//
//            // 3. changeFlightCapacity
//            else if (command.equals("changeFlightCapacity")) {
//                if (inAppUser instanceof TicketSeller) {
//                    System.out.println("please Enter the flight number that you want to change its capacity " +
//                            "and the new capacity in one line in order splited by one space: ");
//                    String[] flightNumber = scanner.nextLine().split(" ");
//                    ((TicketSeller) inAppUser).changeFlightCapacity(Integer.parseInt(flightNumber[0]), Integer.parseInt(flightNumber[1]));
//                } else if (inAppUser == null) {
//                    System.out.println("sign up/log in first. ");
//                } else {
//                    System.out.println("you are not a -Ticketseller- and you cant use this command.");
//                }
//            }
//
//            //help
//            else if (command.equals("help")) {
//                System.out.println("Starting commands in order are : 1-sign up  2-log in\n" +
//                        "if you have logged in as a -Costumer- these are the commands possible for you:\n" +
//                        " 1. showAllReservedThickets\n" +
//                        " 2. purchaseTicket\n" +
//                        " 3. cancelTicket\n" +
//                        "if you have logged in as a -TicketSeller- these are the commands possible for you:\n" +
//                        " 1. addThicket\n" +
//                        " 2. cancelflight\n" +
//                        " 3. changeFlightCapacity\n" +
//                        "and these are common commands for both costumers and ticket sellers:\n" +
//                        " 1. listOfAllTickets\n" +
//                        " 2. searchInTickets" );
//            }
//        }
//    }
//}