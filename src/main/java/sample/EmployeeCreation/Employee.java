package sample.EmployeeCreation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private int id;

    public Employee(String firstName, String lastName, Date birthDate, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Employee "+ id + " : " + firstName + " " + lastName + " with date of birth " + new SimpleDateFormat("dd-MM-yyyy").format(birthDate) + ".";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return ((Employee) obj).lastName.equals(lastName)
                    && ((Employee) obj).firstName.equals(firstName)
                    && ((Employee) obj).birthDate.toString().equals(birthDate.toString())
                    && ((Employee) obj).id == id;
        }
        return false;
    }
}