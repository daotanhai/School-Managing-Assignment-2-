import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Scanner;

public class Teacher extends Members {
    Scanner sc = new Scanner(System.in);
    public Teacher(String teacherName, String teacherBornAdd, String teacherAdd, int teacherDOB, int yearTeaching, String major, Timestamp timestamp) {
        super(teacherName, teacherBornAdd, teacherAdd, teacherDOB,timestamp);
        this.yearStartTeaching = yearTeaching;
        this.major = major;
    }

    public Teacher() {
    }
    Calendar c = Calendar.getInstance();

    // Inheritance interface
    protected void EnterInforTeacher() {
        System.out.println("Name of teacher: ");
        name = sc.nextLine();
        super.IPrintOutInfor();
    }

    // Enter year start to teaching and major of teacher
    protected void EnterMajor(){
        System.out.println("Year start to teaching: ");
        yearStartTeaching = Integer.parseInt(sc.nextLine());
        System.out.println("Enter major of teacher: ");
        major = sc.nextLine();
    }

    // Calculate year of teaching of teacher
    @Override
    public int ICalculateYearOfTeaching(){
        int thamNien;
        thamNien = c.get(Calendar.YEAR) - yearStartTeaching;
        return thamNien;
    }

    // Print out information of teacher
    @Override
    public void IPrintOutInforTeacher() {
        System.out.println("Class Teacher");
        System.out.println("Teacher Name: "+name);
        System.out.print("\nYear start teaching: "+ yearStartTeaching);
        System.out.println("\nmajor: "+ major);
        System.out.println("___________________");
    }
}
