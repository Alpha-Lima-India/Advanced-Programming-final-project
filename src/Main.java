import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome. Please Sign up or if you have signed in already log in now. ");
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
                boolean finalsign = UserManager.SignUp(username,password,username,idnumber);
                if (!finalsign) {
                    System.out.println("sign up not successful. please sign up again. ");
                } else {
                    System.out.println("well done. now you should log in to enter. ");
                }
            }

            // log in
            if (command.equals("log in")) {
                System.out.println("please enter your username: ");
                String username = scanner.nextLine();
                System.out.println("please enter your password");
                String password = scanner.nextLine();
                User user = UserManager.login(username, password);
                if (user != null) {
                    System.out.println("well done. now you can use the program. ");
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
            if (command.equals("showAllReservedThickets")) {
                if (inAppUser instanceof Customer) {
                    ((Customer) inAppUser).showAllReservedThickets();
                } else {
                    System.out.println("you are not a -Costumer- and you cant use this command. ");
                }
            }

            // 2. purchaseTicket
            if (command.equals("purchaseTicket")) {
                if (inAppUser instanceof Customer) {
                    System.out.println("now enter the ticket that you want to book: ");
                    Ticket ticket = scanner.;
                }
            }

            // commands for both :
            // 1. listOfAllTickets
            // 2. searchInTickets

            // commands for a possible costumer :
            // 1. addThicket
            // 2. cancelTicket
            // 3. changeFlightCapacity
        }
    }
}
