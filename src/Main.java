import manager.CourseManagement;
import manager.Enrollment;
import manager.StudentMenegement;
import object.Course;
import object.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static StudentMenegement stdManager = new StudentMenegement();
    static CourseManagement courseManager = new CourseManagement();
    static Enrollment enrollment = new Enrollment();

    public static void main(String[] args) {
        int option = 10;
        while (option != 0) {
            System.out.println("Welcome to my schools");
            System.out.println("1. add new student");
            System.out.println("2. list all student");
            System.out.println("3. get student information");
            System.out.println("4. add new course");
            System.out.println("5. Delete course");
            System.out.println("6. Update course");
            System.out.println("7. List all course");
            System.out.println("8. Enroll course to student");
            System.out.println("9. List all enrollment");
            System.out.println("0. Exits");
            System.out.print("Enter menu option: ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1 -> testAddStudent();
                case 2 -> testListAllStudent();
                case 3 -> testGetStudent();
                case 4 -> testAddCourse();
                case 5 -> testDeleteCourse();
                case 6 -> testUpdateCourse();
                case 7 -> testListAllCourse();
                case 8 -> testEnroll();
                case 9 -> testListEnroll();
            }
            System.out.println("-----------------------");
        }
    }

    private static void testAddStudent(){
        System.out.println("Add new student");
        System.out.print("Enter std Firstname: ");
        String fname = scan.nextLine();
        System.out.print("Enter std Lastname: ");
        String lname = scan.nextLine();
        Student std = new Student(fname,lname);
        boolean added = stdManager.addStudent(std);
        System.out.println(added ? "Student added" : "Error");
    }

    private static void testListAllStudent(){
        System.out.println("All std");
        for (int i = 0 ; i < stdManager.listAllStudent().size() ; i++){
            System.out.println(stdManager.listAllStudent().get(i));
        }
        System.out.println("------------------------");
    }

    private static void testGetStudent(){
        System.out.println("Get student by id");
        System.out.println("Enter Id :");
        int id = scan.nextInt();
        System.out.println("this is results.");
        System.out.println("||-------------------------||");
        System.out.println(stdManager.getStudentById(3));
        System.out.println("||-------------------------||");

    }

    private static void testAddCourse(){
        System.out.println("Add a new course");
        System.out.println("Enter course ID :");
        int courseID = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter course description :");
        String desc = scan.nextLine();
        boolean isSuccess = courseManager.addCourse(new Course(courseID, desc));
        System.out.println(isSuccess ? "Course added" : "Error");
    }

    private static void testDeleteCourse(){
        System.out.println("Delete course");
        System.out.println("Enter course ID :");
        int courseID = scan.nextInt();
        boolean isSuccess = courseManager.deleteCourse(courseID);
        System.out.println(isSuccess ? "Delete success" : "Error");
    }

    private static void testUpdateCourse(){
        System.out.println("Update course");
        System.out.println("Enter course ID that you need to update:");
        int courseID = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter data that you need to update:");
        String desc = scan.nextLine();
        boolean isSuccess = courseManager.updateCourse(courseID, desc);
        System.out.println(isSuccess ? "Updated" : "Error");
    }

    private static void testListAllCourse(){
        System.out.println("List all course");
        System.out.println("---------------------------------");
        for (int i = 0; i<courseManager.listAllCourse().size(); i++){
            System.out.println(courseManager.listAllCourse().get(i));
        }
        System.out.println("--------------------------------");
    }

    private static void testEnroll() {
        System.out.println("Enroll std into course");
        System.out.println("Enter std id:");
        int stdID = scan.nextInt();
        scan.nextLine();
        System.out.println("Example: (Course ID: 1,2,3,4)");
        System.out.println("Enter std course ID: ");
        String courseID = scan.nextLine();
        String[] courseIDs = courseID.split(",");
        int [] allCourseID = Arrays.stream(courseIDs).mapToInt(Integer::parseInt).toArray();
        boolean isSuccess = enrollment.enrollStudentToCourse(stdID, allCourseID);
        System.out.println(isSuccess ? "Add success" : "Error");
    }

    private static void testListEnroll() {
        System.out.println("List Enrollment");
        System.out.println("---------------------------------");
        for (int i = 0; i<enrollment.listStudentEnroll().size(); i++){
            System.out.println(enrollment.listStudentEnroll().get(i));
        }
        System.out.println("--------------------------------");
    }
}