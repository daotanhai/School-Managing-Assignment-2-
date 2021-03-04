import java.sql.Timestamp;
import java.util.Scanner;

public interface OutputInformation {

    default void IPrintOutInforStudent() {

    }

    default void IPrintOutInforTeacher(){

    }
    default void IPrintOutInfor(){
    }
    default int ICalculateYearOfTeaching(){return 0;}
    default double ICalculateAverageGrade(){ return 0;}
}
