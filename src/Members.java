import java.sql.Timestamp;
import java.util.Scanner;

public class Members implements OutputInformation {
    Timestamp timestamp;
    Scanner sc = new Scanner(System.in);
    protected String name, placeBorn, address;
    protected int DOB, gradeMath, gradeLit, gradeEnglish, yearStartTeaching;
    protected String major;
    public Members() {
    }
    public Members(String name, String placeBorn, String address, int DOB, Timestamp timestamp) {
        this.name = name;
        this.placeBorn = placeBorn;
        this.address = address;
        this.DOB = DOB;
        this.timestamp = timestamp;
    }
    protected Timestamp getTimestamp() {
        return timestamp;
    }

    protected void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    // Enter information
    protected void EnterInformation(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.setTimestamp(timestamp);
        System.out.println("Time start to enter information: "+this.getTimestamp().toString());
        System.out.println("Please enter name: ");
        name = sc.nextLine();
        System.out.println("Year of birth: ");
        DOB = Integer.parseInt(sc.nextLine());
        System.out.println("Place was born: ");
        placeBorn = sc.nextLine();
        System.out.println("Address: ");
        address = sc.nextLine();
    }
}
