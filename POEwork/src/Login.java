public class Login {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    //Constructor
    public Login(String userName,String password,String firstName, String lastName){
        this.userName= userName;
        this.password= password;
        this.firstName= firstName;
        this.lastName= lastName;
    }

    //method to attempt login
    public String loginUser(String enteredUsername,String enteredPassword){
        if(enteredUsername.equals(this.userName)&&enteredPassword.equals(this.password)){
            return "Welcome" +" " + firstName + " " + lastName + " " + "It is great to see you again";
        } else{
            return "Username or Password incorrect. Please try again.";
        }
    }
}
