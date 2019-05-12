package sample.EmployeeCreation;

import java.util.Comparator;

public class ComparatorFactory {

    public Comparator<Employee> createComparator (EmployeeField comparatorType) {

        if(comparatorType == null){
            return null;
        }
        if(comparatorType== EmployeeField.ID){
            return new EmployeeComparatorById();

        } else if(comparatorType== EmployeeField.NAME){
            return new EmployeeComparatorByName();

        } else if(comparatorType== EmployeeField.BIRTH_DATE){
            return new EmployeeComparatorByBirthDate();
        }
        return null;
    }

    public enum EmployeeField {
        ID,
        NAME,
        BIRTH_DATE
    }
}
