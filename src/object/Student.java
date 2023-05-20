package object;

public class Student {

    private int stdID;
    private String firstname;
    private String lastname;

    public Student(String firstname, String lastname){
        if (firstname.isEmpty())
            firstname = "Unknowns";
        if (lastname.isEmpty())
            lastname = "Unknowns";
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Student{ id= "+ stdID +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
