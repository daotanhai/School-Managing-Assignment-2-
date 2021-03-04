import java.util.Scanner;
// This class stand for Case0: Exit program
public class Case0 implements GetCaseNumber{
    Scanner sc = new Scanner(System.in);
    @Override
    public int caseNumber(int caseNumber) {
        String choice;
        int continueOrNot =1;
        System.out.println("Do you want to exit? Y/N?");
        //continueOrNot = Integer.parseInt(sc.nextLine());
        choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")){
            continueOrNot = -1;
            System.out.println("You are out from the program. Thank you!");
        }
        else if (choice.equalsIgnoreCase("n")){
            System.out.println("Welcome back!");
        }
        return 0;
    }
}
