import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    public static ArrayList<User> ListOfAllUsers;
    private static int[] idnumbers = {1234, 5678, 1256, 4589};

    public static boolean SignUp(String username, String password, String usertype, int idnumber) {
        User newUser = null;
        for (User user : UserManager.ListOfAllUsers) {
            if (user.userName.equals(username)) {
                newUser = null;
                System.out.println("this username is already chosen please use another one.");
                return false;
            }
        }
        if (usertype.equals("TicketSeller")) {
            for (int i : UserManager.idnumbers) {
                if (i == idnumber) {
                    newUser = new TicketSeller(username, password, idnumber);
                    System.out.println("SignUp Done. ");
                    ListOfAllUsers.add(newUser);
                    return true;
                }
            }
            System.out.println("the id number is not correct. ");
            return false;
        } else if (usertype.equals("Customer")) {
            newUser = new Customer(username, password);
            ListOfAllUsers.add(newUser);
            System.out.println("SignUp Done. ");
            return true;
        } else {
            newUser = null;
            System.out.println("Invalid user type.");
            return false;
        }
    }

    public static User login(String username, String password) {
        for (User user : UserManager.ListOfAllUsers) {
            if (user.userName.equals(username) && user.password.equals(password)) {
                System.out.println("Log in Done. ");
                return user;
            }
        }
        System.out.println("User not found. ");
        return null;
    }
}
