import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("listofalltickets.txt"));
            String line;
            while ( (line = reader.readLine()) != null) {
                String[] inputsForMakingATicket = line.split(" ");
                Ticket ticket = new Ticket( inputsForMakingATicket[0], Integer.parseInt(inputsForMakingATicket[1]), inputsForMakingATicket[2], Integer.parseInt(inputsForMakingATicket[3]), inputsForMakingATicket[4], inputsForMakingATicket[5] );
                Ticket.tickets.add(ticket);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("listofusers.txt"));
            String line;
            while ( (line = reader1.readLine()) != null) {
                String[] inputsForMakingATicket = line.split(" ");
                String username = inputsForMakingATicket[0];
                String password = inputsForMakingATicket[1];
                int idnumber = Integer.parseInt(inputsForMakingATicket[2]);
                String firstname = inputsForMakingATicket[3];
                String lastname = inputsForMakingATicket[4];
                String phonenumber = inputsForMakingATicket[5];
                User user = UserManager.getUserByUsername(username, password, idnumber, firstname, lastname, phonenumber);
                UserManager.ListOfAllUsers.add(user);
            }
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader2 = new BufferedReader(new FileReader("listofbookedtickets.txt"));
            String line;
            while ( (line = reader2.readLine()) != null) {
                String[] inputsForMakingATicket = line.split(" ");
                String username = inputsForMakingATicket[inputsForMakingATicket.length - 1];
                Customer customer = (Customer) UserManager.getCostumerByUsername(username);
                for (int i = 0; i < inputsForMakingATicket.length - 1; i++) {
                    Ticket ticket = Ticket.getTicketByFlightNumber(Integer.parseInt(inputsForMakingATicket[i]));
                    customer.BookedThickets.add(ticket);
                }
            }
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            BufferedReader reader2 = new BufferedReader(new FileReader("listofpassengers.txt"));
//            String line;
//            while ( (line = reader2.readLine()) != null) {
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to our airline \n   Please Sign up or if you have signed up already log in now or use 'help' command. ");
        String command = "";
        User inAppUser = null;


        while (!command.equals("exit")) {

            command = scanner.nextLine();
            // sign up
            if (command.equals("sign up")) {
                int idnumber = 0;
                System.out.println("please enter your usertype: ");
                String Usertype = scanner.nextLine();
                System.out.println("please enter your username: ");
                String username = scanner.nextLine();
                System.out.println("please enter your password: ");
                String password = scanner.nextLine();
                if (Usertype.equals("TicketSeller")) {
                    System.out.println("please enter your idnumber: ");
                    idnumber = scanner.nextInt();
                }
                boolean finalsign = UserManager.SignUp(username,password,Usertype,idnumber);
                if (!finalsign) {
                    System.out.println("sign up not successful. please sign up again. ");
                } else {
                    System.out.println("well done. now you should log in to enter. ");
                }
            }

            // log in
            else if (command.equals("log in")) {
                System.out.println("please enter your username: ");
                String username = scanner.nextLine();
                System.out.println("please enter your password");
                String password = scanner.nextLine();
                User user = UserManager.login(username, password);
                if (user != null) {
                    System.out.println("well done. now you can use the program. for quit enter 'end task' please. ");
                    inAppUser = user;
                } else {
                    System.out.println("if you dont have an account you should sign up first. use -sign up- command. ");
                }
            }

            // commands for a possible costumer :
            // 1. showAllReservedThickets
            // 2. purchaseTicket
            // 3. cancelTicket

            // 1. showAllReservedThickets
            else if (command.equals("showAllReservedThickets")) {
                if (inAppUser instanceof Customer) {
                    ((Customer) inAppUser).showAllReservedThickets();
                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Costumer- and you cant use this command.");
                }
            }

            // 2. purchaseTicket
            else if (command.equals("purchaseTicket")) {
                if (inAppUser instanceof Customer) {
                    //test
                    if (((Customer) inAppUser).getFirstName() == null || ((Customer) inAppUser).getLastName() == null || ((Customer) inAppUser).getPhoneNumber() == null) {
                        System.out.println("your profile is not complete. fill it first. ");
                    } else {
                        System.out.println("enter the -flight number- ticket that you want to book: ");
                        int flightnum = scanner.nextInt();
                        boolean confirm = false;
                        for (Ticket ticket : Ticket.tickets) {
                            if (ticket.getflightNumber() == flightnum) {
                                ((Customer) inAppUser).purchaseTicket(ticket);
                                confirm = true;
                            }
                        }
                        if (!confirm) {
                            System.out.println("wrong flight number. ");
                        }
                    }

                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Costumer- and you cant use this command.");
                }
            }

            // 3. cancelTicket
            else if (command.equals("cancelTicket")) {
                if (inAppUser instanceof Customer) {
                    System.out.println("enter the -flight number- that you want to cancel: ");
                    int flightnum = scanner.nextInt();
                    ((Customer) inAppUser).cancelTicket(flightnum);
                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Costumer- and you cant use this command.");
                }
            }

            // 4. complete the user profile
            else if (command.equals("user profile")) {
                if (inAppUser instanceof Customer) {
                    System.out.println("your profile datas are\n " + "FirstName: " +  ((Customer) inAppUser).getFirstName() + "\n LastName: " + ((Customer) inAppUser).getLastName() + "\n PhoneNumber: " + ((Customer) inAppUser).getPhoneNumber());
                    System.out.println("Do you want to edit your profile? Y/N");
                    String command1 = scanner.nextLine().toLowerCase();
                    if (command1.equals("y")) {
                        System.out.println("you are editing your profile.\n please enter your firstname, lastname and phone number in order in one line splited by one space.  ");
                        String[] inputs = scanner.nextLine().split(" ");
                        String firstname = inputs[0];
                        String lastname = inputs[1];
                        String phoneNumber = inputs[2];
                        ((Customer) inAppUser).initilizeTheProfile(firstname, lastname, phoneNumber);
                        System.out.println("your profile has been changed. ");
                    } else if (command1.equals("n")) {
                        System.out.println("profile editing finished. ");
                    } else {
                        System.out.println("Wrong command. ");
                    }
                } else if (inAppUser == null ){
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Costumer- and you cant use this command.");
                }
            }

            // commands for both :
            // 1. listOfAllTickets
            // 2. searchInTickets

            // 1. listOfAllTickets
            else if (command.equals("listOfAllTickets")) {
                if (inAppUser instanceof Customer || inAppUser instanceof TicketSeller) {
                    Ticket.listOfAllTickets();
                } else {
                    System.out.println("sign up/log in first. ");
                }
            }

            // 2. searchInTickets
            else if (command.equals("searchInTickets")) {
                if (inAppUser != null) {
                    System.out.println("Enter your origin: ");
                    String origin = scanner.nextLine();
                    System.out.println("Enter your destination: ");
                    String destination = scanner.nextLine();
                    System.out.println("Enter a date: ");
                    String date = scanner.nextLine();
                    Ticket.searchInTickets(origin, destination, date);
                } else {
                    System.out.println("sign up/log in first. ");
                }
            }

            // commands for a possible Ticket seller :
            // 1. addThicket
            // 2. cancelTicket
            // 3. changeFlightCapacity

            // 1. addThicket
            else if (command.equals("addThicket")) {
                if (inAppUser instanceof TicketSeller) {
                    System.out.println("Enter the date, flightNumber, flightHour, capacity, origin and destination of the flight " +
                                            "in one line in order and split them by one space. ");
                    String[] inputs = scanner.nextLine().split(" ");
                    ((TicketSeller) inAppUser).addThicket(inputs[0], Integer.parseInt(inputs[1]), inputs[2], Integer.parseInt(inputs[3]), inputs[4], inputs[5]);
                    //System.out.println("Ticket added.");
                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Ticket seller- and you cant use this command.");
                }
            }

            // 2. cancelflight
            else if (command.equals("cancelflight")) {
                if (inAppUser instanceof TicketSeller) {
                    System.out.println("please Enter the flight number that you want to cancel: ");
                    int numberOfFlight = scanner.nextInt();
                    ((TicketSeller) inAppUser).cancelTicket(numberOfFlight);
                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Ticketseller- and you cant use this command.");
                }
            }

            // 3. changeFlightCapacity
            else if (command.equals("changeFlightCapacity")) {
                if (inAppUser instanceof TicketSeller) {
                    System.out.println("please Enter the flight number that you want to change its capacity " +
                                            "and the new capacity in one line in order splited by one space: ");
                    String[] flightNumber = scanner.nextLine().split(" ");
                    ((TicketSeller) inAppUser).changeFlightCapacity(Integer.parseInt(flightNumber[0]), Integer.parseInt(flightNumber[1]));
                } else if (inAppUser == null) {
                    System.out.println("sign up/log in first. ");
                } else {
                    System.out.println("you are not a -Ticketseller- and you cant use this command.");
                }
            }

            //help
            else if (command.equals("help")) {
                System.out.println("Starting commands in order are : 1-sign up  2-log in  3-end task(to log out from your account)\n" +
                        "if you have logged in as a -Customer- these are the commands possible for you:\n" +
                            " 1. showAllReservedThickets\n" +
                            " 2. purchaseTicket\n" +
                            " 3. cancelTicket\n" +
                            " 4. user profile\n" +
                        "if you have logged in as a -TicketSeller- these are the commands possible for you:\n" +
                            " 1. addThicket\n" +
                            " 2. cancelflight\n" +
                            " 3. changeFlightCapacity\n" +
                        "and these are common commands for both costumers and ticket sellers:\n" +
                            " 1. listOfAllTickets\n" +
                            " 2. searchInTickets" );
            }

            else if (command.equals("end task")) {
                if (inAppUser != null) {
                    System.out.println("if you quit the app you should login again to work with program. are you sure that you want to quit? Y/N");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y")){
                        inAppUser = null;
                        System.out.println("Thank you for choosing us. Have a nice flight. ");
                    } else if (input.equals("n")) {
                        System.out.println("enter your commands: ");
                    } else {
                        System.out.println("Wrong command. ");
                    }
                } else {
                    System.out.println("sign up/log in first. ");
                }
            }

//            else {
//                System.out.println("invalid command. ");
//            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("listofalltickets.txt"));
            for (Ticket ticket : Ticket.tickets) {
                writer.write( ticket.getDate() + " " + ticket.getflightNumber() + " " + ticket.getflightHour() + " " + ticket.getRemaindCapacity() + " " + ticket.getOrigin() + " " + ticket.getDestination() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("listofusers.txt"));
            for (User user : UserManager.ListOfAllUsers) {
                if (user instanceof Customer) {
                    writer.write(user.userName + " " + user.password + " " + "0" + " " + ((Customer) user).getFirstName() + " " + ((Customer) user).getLastName() + " " + ((Customer) user).getPhoneNumber() +  "\n");
                } else if (user instanceof TicketSeller) {
                    writer.write(user.userName + " " + user.password + " " + ((TicketSeller) user).getIdnumber() + " 0 0 0\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("listofbookedtickets.txt"));
            for (User user : UserManager.ListOfAllUsers) {
                if (user instanceof Customer) {
                    for (Ticket ticket : ((Customer) user).BookedThickets) {
                        if (Ticket.tickets.contains(ticket)) {
                            writer.write(ticket.getflightNumber() + " ");
                        }
                    }
                    writer.write(user.userName + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}