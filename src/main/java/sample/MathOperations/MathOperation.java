package sample.MathOperations;

import java.util.List;

public class MathOperation {

    public static Double min (List<Double> integers) {

        double minValue = integers.get(0);

        for (int i = 1; i < integers.size(); i++) {
            if (minValue > integers.get(i)) {
                minValue = integers.get(i);
            }
        }
        return minValue;
    }

    public static Double max (List<Double> integers) {
        double maxValue = integers.get(0);

        for (int i = 1; i < integers.size(); i++) {
            if (maxValue < integers.get(i)) {
                maxValue = integers.get(i);
            }
        }
        return maxValue;
    }

    public static Double average (List<Double> integers) {
        int sum = 0;

        for (int i = 0; i < integers.size(); i++) {
            sum += integers.get(i);
        }
        return (double) sum / integers.size();
    }
}
