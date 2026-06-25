import javax.swing.*;

void main() {
    String studentNum;
    String name;
    String surname;
    String email;


    studentNum= JOptionPane.showInputDialog("Enter Student Number");
    JOptionPane.showMessageDialog(null, studentNum);

    name= JOptionPane.showInputDialog("Enter Student Name");
    JOptionPane.showMessageDialog(null, name);

    surname= JOptionPane.showInputDialog("Enter Student Surname");
    JOptionPane.showMessageDialog(null, surname);

    email= JOptionPane.showInputDialog("Enter email");
    JOptionPane.showMessageDialog(null, email);

    String phoneInput= JOptionPane.showInputDialog("Enter Phone Number");
    int phoneNo= Integer.parseInt(phoneInput);

    String markOneInput= JOptionPane.showInputDialog("Enter Mark One");
    int markOne= Integer.parseInt(markOneInput);

    String markTwoInput= JOptionPane.showInputDialog("Enter Mark Two");
    int markTwo= Integer.parseInt(markTwoInput);

    String assignmentInput= JOptionPane.showInputDialog("Enter Assignment mark");
    int assignmentMark= Integer.parseInt(assignmentInput);

    String examInput= JOptionPane.showInputDialog("Enter Exam Mark");
    int exam= Integer.parseInt(examInput);

    System.out.println("Student name is "+name + "\n" + "Student surname is "+surname  + "\n" + "Student number is "+studentNum + "\n"  +"Student email is"+email + "\n" + "Student phone number is "+phoneNo + "\n" + "Student mark 1 is "+markOne + "\n" + "Student mark 2 is "+markTwo + "\n" + "Student assignment mark is "+assignmentMark + "\n" + "Student exam mark is "+exam );


    double Dpmark= CalculateDpmark(markOne, markTwo, assignmentMark);
    System.out.println("Your Dp Mark is "+Dpmark);

    double Finalmark= CalculateFinalmark(Dpmark, exam);
    System.out.println("Your Final mark is "+Finalmark);

    if(Finalmark>=0&Finalmark<=49){
        System.out.println("Fail.");
    } else if(Finalmark>=50&Finalmark<=74){
        System.out.println("Pass.");
    } else if (Finalmark>=75&Finalmark<=100) {
        System.out.println("Pass with distinction.");

    }

}

public static double CalculateDpmark(int markOne, int markTwo, int assignmentMark){
    return (double) ((markOne+markTwo+assignmentMark)/3);
}

public static double CalculateFinalmark(double Dpmark, int exam){
    return(double) ((Dpmark*0.4)+(exam*0.6));
}

