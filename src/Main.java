import manager.DatabaseConnecter;
import manager.StudentMenegement;
import object.Student;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static StudentMenegement stdManager = new StudentMenegement();

    public static void main(String[] args) {
        int option = 10;
        while (option != 0) {
            System.out.println("Welcome to my schools");
            System.out.println("1. add new student");
            System.out.println("2. list all student");
            System.out.println("3. get student information");
            System.out.println("4. add new course");
            System.out.println("0. Exits");
            option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1 -> testAddStudent();
                case 2 -> testListAllStudent();
                case 3 -> testGetStudent();
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

    private static void addCourse(){

    }
}