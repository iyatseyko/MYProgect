package sample.EmployeeCreation;

import org.apache.poi.openxml4j.opc.internal.FileHelper;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndCreateEmployeeFromCSV {

    public static final  String BASE_PATH = "%s.csv";

    public static List<Employee> readEmployeeDataFromCSV(String fileName) {
        List<Employee> employees = new ArrayList<Employee>();

        try {

            InputStream is = FileHelper.class
                    .getClassLoader().getResourceAsStream(String.format(BASE_PATH,fileName));
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(";");
                Employee employee = createEmployee(attributes);
                employees.add(employee);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        return employees;
    }

    public static Employee createEmployee(String[] employeeData) {
        int id = Integer.parseInt(employeeData[0]);
        String firstName = employeeData[1];
        String lastName = employeeData[2];

        Date birthDate = null;
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            birthDate = df.parse(employeeData[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Employee(firstName, lastName, birthDate, id);
    }
}
