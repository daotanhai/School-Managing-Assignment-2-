import java.sql.Timestamp;
import java.util.Scanner;

public class Student extends Members {
    Scanner sc = new Scanner(System.in);
    public Student(String name, String placeBorn, String address, int yearBorn, int gradeMath, int gradeLit, int gradeEnglish, Timestamp timestamp) {
        super(name, placeBorn, address, yearBorn,timestamp);
        this.gradeMath = gradeMath;
        this.gradeLit = gradeLit;
        this.gradeEnglish = gradeEnglish;
    }
    public Student() { }
    // Method enter student information
    protected void EnterInforStudent() {
        super.EnterInformation();
    }
    // Enter grade
    protected void EnterGrade(){
        System.out.println("Please enter the Math grade: ");
        gradeMath = sc.nextInt();

        System.out.println("Please enter the Literature grade: ");
        gradeLit = sc.nextInt();

        System.out.println("Please enter the English grade: ");
        gradeEnglish = sc.nextInt();
    }

    // Print our information of student
    @Override
    public void IPrintOutInforStudent() {
        System.out.println("Class Student");
        System.out.println("\nName: "+ name);
        System.out.print("\nMath grade: "+ gradeMath);
        System.out.print("\nLiterature grade: "+ gradeLit);
        System.out.println("\nEnglish grade: "+ gradeEnglish);
        System.out.println("___________________");
    }

    // calculate GPA
    @Override
    public double ICalculateAverageGrade(){
        double GPA;
        GPA = (gradeMath + gradeLit + gradeEnglish)/3;
        return GPA;
    }
}
