package sample.EmployeeCreation;
import java.util.Collections;
import java.util.List;

import static sample.EmployeeCreation.ReadAndCreateEmployeeFromCSV.readEmployeeDataFromCSV;

public class EmployeeRun {

    public static String runEmployee(String sortOrder) {

        ComparatorFactory factoryComparator = new ComparatorFactory();
        Boolean notErr = true;
        String res = "";
        List<Employee> employee1 = readEmployeeDataFromCSV("Employee");
        List<Employee> employee2 = readEmployeeDataFromCSV("Employee2");

        switch (sortOrder) {
            case "id":
                Collections.sort(employee1, factoryComparator.createComparator(ComparatorFactory.EmployeeField.ID));
                Collections.sort(employee2, factoryComparator.createComparator(ComparatorFactory.EmployeeField.ID));
                break;
            case "name":
                Collections.sort(employee1, factoryComparator.createComparator(ComparatorFactory.EmployeeField.NAME));
                Collections.sort(employee2, factoryComparator.createComparator(ComparatorFactory.EmployeeField.NAME));
                break;
            case "birth date":
                Collections.sort(employee1, factoryComparator.createComparator(ComparatorFactory.EmployeeField.BIRTH_DATE));
                Collections.sort(employee2, factoryComparator.createComparator(ComparatorFactory.EmployeeField.BIRTH_DATE));
                break;
            default:
                notErr = false;
                res +="You type incorrect variant of sort order. Please, try again";
        }

        if (notErr==true) {

            res +="Employee from first file:\n";
            for (Employee e : employee1) {
                res += e+"\n";
            }
            res+="\nEmployee from second file\n";
            for (Employee e : employee2) {
                res += e+"\n";
            }

            List<Employee> uniqueEmployee = TakeUniqueAndDuplicateEmployee.takeUniqueEmployee(employee1, employee2);
            res +="\nThis is uniqueEmployee list\n";
            for (Employee e : uniqueEmployee) {
                res +=e+"\n";
            }
            List<Employee> duplicateList = TakeUniqueAndDuplicateEmployee.takeDuplicateEmployee(employee1, employee2);
            res +="\nThis is duplicateEmployee list\n";
            for (Employee e : duplicateList) {
                res +=e+"\n";
            }
        }
        return res;
    }

}
