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

    public void setStdID(int id) {
        this.stdID = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Student{ id= "+ stdID +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
