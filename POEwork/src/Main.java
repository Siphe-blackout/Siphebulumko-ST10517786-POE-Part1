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
        int choice;
        do{
            System.out.println("Enter choice");
            System.out.println("1.Send Messages");
            System.out.println("2. Show sent messages");
            System.out.println("3. Quit");
            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 1:
                    //Collects recipient and message
                    System.out.println("Enter Recipient number");
                    String recipient = s.nextLine();

                    System.out.println("Enter message");
                    String text= s.nextLine();

                    Message msg= new Message(recipient,text);

                    System.out.println(msg.checkRecipientno());
                    System.out.println(msg.checkMessageLength());

                    System.out.println("Choose option: Send/ store/ discard");
                    String option= s.nextLine();
                    //Calling Message class
                    System.out.println(msg.sendMessage(option));

                    System.out.println(msg.printMessage());
                    break;

                case 2:
                    System.out.println("Feature not done. Coming soon.");
                    break;
                case 3:
                    System.out.println("Thank you for using the service.");
            }

        } while(choice!=3);
        }


    }


