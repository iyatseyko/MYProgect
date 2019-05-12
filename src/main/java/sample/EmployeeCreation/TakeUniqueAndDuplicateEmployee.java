package sample.EmployeeCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TakeUniqueAndDuplicateEmployee{

    public static <E> List<E> takeUniqueEmployee(List<E> input1, List<E> input2) {

        final List<E> list = input1.stream().filter(e -> !input2.contains(e)).collect(Collectors.toList());
        final List<E> list2 = input2.stream().filter(e -> !input1.contains(e) && !list.contains(e)).collect(Collectors.toList());

        List<E> uniqueEmployee = new ArrayList<E>();
        uniqueEmployee.addAll(list);
        uniqueEmployee.addAll(list2);
        return uniqueEmployee;
    }

    public static <E> List<E> takeDuplicateEmployee(List<E> input1, List<E> input2) {

        List<E> duplicateList = new ArrayList<>();
        for (E item : input1) {
            if (input2.contains(item)) {
                duplicateList.add(item);
            }
        }
        return duplicateList;
    }
}
