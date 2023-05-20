package object;

public class Course {
    private int courseID;
    private String courseDesc;
    private String instructorID;

    public Course(int courseID, String courseDesc){
        this.courseID = courseID;
        this.courseDesc = courseDesc;
        this.instructorID = null;
    }
    public Course(int courseID, String courseDesc, String instructorID){
        this.courseID = courseID;
        this.courseDesc = courseDesc;
        this.instructorID = instructorID;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public String getInstructorID() {
        return instructorID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", instructorID='" + instructorID + '\'' +
                '}';
    }
}
