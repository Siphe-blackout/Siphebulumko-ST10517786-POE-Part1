import java.util.Scanner;

public class Registration {
    String userName;
    String password;
    String phoneNo;
    String firstName;
    String lastName;

    //Sets and checks conditions for Username-must be less that or equal to 5 characters and contain "_"
    public boolean checkuserName(String userName){
        return userName.length()<=5 && userName.contains("_");
    }

    //Sets and checks conditions for Password-must be at least 8 chars, can contain upper class, digit or special chars
    public boolean checkPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUppercase = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUppercase = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUppercase && hasSpecial && hasDigit;
    }

    //Sets and checks conditions for Phone number-must start with +27 or 0 and must have 9 digits after
    public boolean checkPhoneNo(String phoneNo){
        return phoneNo.matches("(\\+27|0)[0-9]{9}");
    }

    public void Register(){
       Scanner s= new Scanner(System.in);
        //Enter user First and Last names
        System.out.println("Enter First Name");
        firstName=s.nextLine();
        System.out.println("Enter Last Name");
        lastName=s.nextLine();

       //Username
        do{
            System.out.println("Enter Username");
            userName=s.nextLine();
            if (checkuserName(userName)) {
                System.out.println("Username successfully captured.");
            }
            if(!checkuserName(userName)){
                System.out.println("Username is not formatted correctly. Ensure the Username is is not more than five characters and contains an underscore.");
            }
        }while(!checkuserName(userName));

        //Phone number
        do{
            System.out.println("Enter Phone number");
            phoneNo=s.nextLine();
            if (checkPhoneNo(phoneNo)) {
                System.out.println("Phone Number successfully captured.");
            }
            if(!checkPhoneNo(phoneNo)){
                System.out.println("Invalid Phone Number. Ensure phone number is 10 digits and contains country code.");
            }
        }while(!checkPhoneNo(phoneNo));

        //Password
        while(true){
            System.out.println("Enter password");
            password=s.nextLine();

            if(checkPassword(password)){
                System.out.println("Password successfully captured.");
                break;
            }
            else{
                System.out.println("Incorrect password.");
                System.out.println("Password should contain a Capital letter,Special character or digits.");
            }

        }

        //When user inserts all correct information
        System.out.println("Registration Successful");

    }

}
