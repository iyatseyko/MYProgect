package sample.EmployeeCreation;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class EmployeeComparatorByBirthDate implements Comparator<Employee> {


    @Override
    public int compare(Employee e1, Employee e2) {
        return new SimpleDateFormat("yyyy-mm-dd").format(e1.getBirthDate()).compareTo(new SimpleDateFormat("yyyy-MM-dd").format(e2.getBirthDate()));
    }
}
