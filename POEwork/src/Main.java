import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.Register();

        Scanner s = new Scanner(System.in);
        Login login = new Login(registration.userName, registration.password,
                registration.firstName, registration.lastName);

        System.out.println("Please log in now.");

        // For loop: maximum 3 attempts
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Username: ");
            String loginUser = s.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = s.nextLine();

            String message = login.loginUser(loginUser, loginPass);
            System.out.println(message);

            // If login is successful, break out of the loop
            if (message.startsWith("Welcome")) {
                break;
            }

            // If this was the 3rd failed attempt, lock the account
            if (i == 2) {
                System.out.println("Too many failed attempts. Account locked.");
            }
        }
    }
}

