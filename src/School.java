
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class School {

    // Create list for Student and Teacher
    List<Members> membersList = new ArrayList<>();
    private static final String TeacherClass = "Teacher";
    private static final String StudentClass = "Student";
    private static final SimpleDateFormat showTime = new SimpleDateFormat("yyyy.MM.dd-HH.mm");
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int continueOrNot;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.print("Time: "+showTime.format(timestamp));
        School Func = new School();
        Scanner sc = new Scanner(System.in);
        System.out.println("Using Factory Patterns instead of SwitchCase ");
        try {
            do {
                continueOrNot = Func.processFatory(Func.UserChoice());
            } while (continueOrNot !=0);
        }catch (Exception e){
            System.out.println("Invalid case");
        }

        // test with old code switch case
        /*int continueOrNot1 =1;
        String choice;
        do {
            System.out.println("SWITCH CASE");
            switch (Func.UserChoice()){
                case 0:
                    System.out.println("Do you want to exit? Y/N?");
                    //continueOrNot = Integer.parseInt(sc.nextLine());
                    choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("y")){
                        continueOrNot1 = -1;
                        System.out.println("You are out from the program. Thank you!");
                        break;
                    }
                    else if (choice.equalsIgnoreCase("n")){
                        System.out.println("Welcome back!");
                    }
                case 1:
                    System.out.println("Case 1");
                    Func.PrintOutInfor();
                    break;
                case 2:
                    System.out.println("Case 2");
                    Func.HighestYearTeaching();
                    break;
                case 3:
                    System.out.println("Case 3");
                    Func.FindingSpecialTeacher();
                    break;
                case 4:
                    System.out.println("Case 4");
                    Func.CalculateAverageGrade();
                    break;
                case 5:
                    System.out.println("Case 5");
                    Func.CalculateHighestAverageGrade();
                    break;
                case 6:
                    System.out.println("Case 6");
                    Func.RankingStudents();
                    break;
                case 7:
                    System.out.println("Case 7");
                    Func.EnterInformation();
                    break;
                // Add more case into switch case
                // Delete case 8 by comment the code
                *//*case 8:
                    System.out.println("Case 8");
                    Func.PrintInforTeacher();
                    break;*//*
                default:
                    System.out.println("No case!");
                    break;
            }
        } while (continueOrNot1 ==1);*/
    }
    // Using factory pattern
    protected int processFatory(int caseNumber){
        GetCaseNumber getCaseNumber = OperatorFactory
                .getCaseNameOptional(caseNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid case!"));
        return getCaseNumber.caseNumber(caseNumber);
    }
    // Create function to print only information of teacher
    protected void PrintInforTeacher(){
        for (Members members : membersList) {
            if (members.getClass().getSimpleName().equalsIgnoreCase(TeacherClass)) {
                members.IPrintOutInforTeacher();
            }
        }
    }

    // Create menu to control the program
    protected int UserChoice(){
        int userChoice;
        System.out.println("\nManaging school Assignment 2 Advanced Programming Dao Tan Hai");
        System.out.println("1. Export information of list");
        System.out.println("2. Calculate highest year of teaching of teacher");
        System.out.println("3. Finding teacher have year of teaching >5 and belong to natural major");
        System.out.println("4. Calculate the GPA of students");
        System.out.println("5. Calculate highest GPA of students");
        System.out.println("6. Ranking student GPA");
        System.out.println("7. Enter information for teacher and student");
        System.out.println("8. Print out information of teacher - THIS FUNCTION HAS BEEN DELETED");
        System.out.println("0. Quit program");
        System.out.println("Please enter your choice: ");
        userChoice = Integer.parseInt(sc.nextLine());
        return userChoice;
    }

    // Enter information for student and teacher
    protected void EnterInformation() {

        int userChoice, tiepTuc;
        do {
            System.out.println("1. Enter student information\n2. Enter teacher information");
            userChoice = Integer.parseInt(sc.nextLine());
            if (userChoice == 1) {
                System.out.println("Student");
                Student hs = new Student();
                hs.EnterInforStudent();
                hs.EnterGrade();
                System.out.println("Student enter done");
                membersList.add(hs);
            } else if (userChoice == 2) {
                System.out.println("Teacher");
                Teacher gv = new Teacher();
                gv.EnterInforTeacher();
                gv.EnterMajor();
                System.out.println("Teacher enter done");
                membersList.add(gv);
            }
            System.out.println("Do you want to continue? 1/2 (Y/N)");
            tiepTuc = Integer.parseInt(sc.nextLine());
        } while (tiepTuc == 1);
    }

    // Method to export data to screen
    protected void PrintOutInfor() {
        // Generate dummy data instead of enter when debug
        Student hs1 = new Student("Student 1", "Born Place 1", "Address 1", 2001, 10, 9, 8,new Timestamp(System.currentTimeMillis()));
        Student hs2 = new Student("Student 2", "Born Place 2", "Address 2", 2002, 9, 8, 7,new Timestamp(System.currentTimeMillis()));
        Members gv1 = new Teacher("Teacher 1","Vietnam","Address teacher", 1900,1911,"natural",new Timestamp(System.currentTimeMillis()));
        membersList.add(hs1);
        membersList.add(hs2);
        membersList.add(gv1);
        if (membersList.size() == 0) {
            System.out.println("Do not have any members. Please enter again!");
            EnterInformation();
        }
        for (Members members : membersList) {
            String memberTypes;
            memberTypes = members.getClass().getSimpleName();

            if (memberTypes.equals("Student")) {
                System.out.println("\nStudent");
                members.IPrintOutInfor();
                members.IPrintOutInforStudent();
            } else if (memberTypes.equals("Teacher")) {
                System.out.println("\nTeacher");
                members.IPrintOutInfor();
                members.IPrintOutInforTeacher();
            }
        }
    }

    // Calculate highest year of teaching
    protected void HighestYearTeaching() {
        if (membersList.size() == 0) {
            System.out.println("Do not have any members in the list! Please fill the list before query");
            EnterInformation();
        }
        Members highestYearTeacher;
        highestYearTeacher = membersList.get(0);
        System.out.println("\nTeacher have highest year of teaching: ");
        int count = 0;
        for (Members members : membersList) {
/*            if (membersList.get(i).getClass().getSimpleName().equals("Student")) {
            }*/
            if (members.getClass().getSimpleName().equalsIgnoreCase(TeacherClass)) {
                if (highestYearTeacher.ICalculateYearOfTeaching() <= members.ICalculateYearOfTeaching()) {
                    count++;
                    highestYearTeacher = members;
                }
            }
        }
        System.out.println("\nHave " + count + " number of teachers have the highest year of teaching");
        System.out.println("Highest year of teaching: " + highestYearTeacher.ICalculateYearOfTeaching());
        System.out.println("___________________");
        System.out.println("Information of teacher has highest year of teaching: ");
        highestYearTeacher.IPrintOutInforTeacher();
    }

    // Method searching special teacher
    protected void FindingSpecialTeacher() {
        int count = 0;
        System.out.println("\nFind a teacher who is> 5 years old in teaching and his major is in natural.");
        System.out.println("___________________");
        for (Members members : membersList) {
            if (members.getClass().getSimpleName().equalsIgnoreCase(TeacherClass)) {
                if (members.ICalculateYearOfTeaching() >= 5 && members.major.equalsIgnoreCase("natural")) {
                    count++;
                    System.out.println("Found special teacher");
                    members.IPrintOutInfor();
                    members.IPrintOutInforTeacher();
                }
            }
        }
        if (count == 0) {
            System.out.println("Sorry! Do not have special teacher");
        }
    }

    // Method to calculate GPA
    protected void CalculateAverageGrade() {
        double gpa;
        System.out.println("Calculate the GPA of student");
        for (Members members : membersList) {
            if (members.getClass().getSimpleName().equalsIgnoreCase(StudentClass)) {
                gpa = (members.gradeMath + members.gradeLit + members.gradeEnglish) / 3;
                members.IPrintOutInfor();
                members.IPrintOutInforStudent();
                System.out.println("GPA: " + gpa);
                System.out.println("");
            }
        }
    }
    // Method calculate highest average grade
   protected void CalculateHighestAverageGrade() {
        int count=0;
        // Assign MaxGrade on top of list
        Members MaxGrade;
        MaxGrade = membersList.get(0);
       System.out.println("Calculate the highest GPA");
       for (Members members : membersList) {
           if (members.getClass().getSimpleName().equalsIgnoreCase(StudentClass)) {
               count++;
               if (MaxGrade.ICalculateAverageGrade() <= members.ICalculateAverageGrade()) {
                   MaxGrade = members;
                   MaxGrade.IPrintOutInfor();
                   MaxGrade.IPrintOutInforStudent();
                   System.out.println("Highest GPA: " + MaxGrade.ICalculateAverageGrade());
               }
           }
       }
       if (count ==0){
           System.out.println("Sorry! Do not have any student");
       }
    }
    // Ranking student
    protected void RankingStudents(){
        System.out.println("Student ranking");
        for (Members members : membersList) {
            if (members.getClass().getSimpleName().equalsIgnoreCase(StudentClass)) {
                if (members.ICalculateAverageGrade() < 5) {
                    System.out.println("Weak student");
                    members.IPrintOutInfor();
                    members.IPrintOutInforStudent();
                } else if (members.ICalculateAverageGrade() >= 5 && members.ICalculateAverageGrade() < 7) {
                    System.out.println("Average student");
                    members.IPrintOutInfor();
                    members.IPrintOutInforStudent();
                } else if (members.ICalculateAverageGrade() >= 7 && members.ICalculateAverageGrade() < 8) {
                    System.out.println("Good student");
                    members.IPrintOutInfor();
                    members.IPrintOutInforStudent();
                } else if (members.ICalculateAverageGrade() >= 8 && members.ICalculateAverageGrade() < 9) {
                    System.out.println("Excellent student");
                    members.IPrintOutInfor();
                    members.IPrintOutInforStudent();
                } else if (members.ICalculateAverageGrade() >= 9) {
                    System.out.println("Outstanding student! Congratulations!");
                    members.IPrintOutInfor();
                    members.IPrintOutInforStudent();
                }
            }
        }
    }
}
