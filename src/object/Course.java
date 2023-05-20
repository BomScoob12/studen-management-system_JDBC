package object;

public class Course {
    private int courseID;
    private String courseDesc;

    public Course(int courseID, String courseDesc){
        this.courseID = courseID;
        this.courseDesc = courseDesc;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseDesc='" + courseDesc + '\'' +
                '}';
    }
}
