package object;

public class Instructor {
    private int instructorID;
    private String instructorName;

    public Instructor(int instructorID, String instructorName){
        this.instructorID = instructorID;
        this.instructorName = instructorName;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }
}
