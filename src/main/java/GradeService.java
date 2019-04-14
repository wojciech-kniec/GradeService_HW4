import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class GradeService {

    public String[][] calculateAverage(String[][] data) {

        String[][] emptyArray = new String[][]{{}};
        DecimalFormat df = new DecimalFormat("0.00");
        if (data == null) {
            return emptyArray;
        } else if (data.length == 0) {
            return emptyArray;
        }

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        List<String> students = new ArrayList<>();
        Map<String, Double> studentsToAmountOfGrades = new HashMap<>();

        for (String[] newData : data) {
            if (!students.contains(newData[0])) {
                students.add(newData[0]);
                studentsToAmountOfGrades.put(newData[0], 1.0);
            } else {
                double amount = studentsToAmountOfGrades.get(newData[0]) + 1.0;
                studentsToAmountOfGrades.put(newData[0], amount);
            }
        }

        Map<String, Double> studentsToGrades = new HashMap<>();

        for (String s : students) studentsToGrades.put(s, 0.0);
        for (String[] newData : data) {
            double grade = studentsToGrades.get(newData[0]);
            double grade2 = Double.parseDouble(newData[1]);
            studentsToGrades.put(newData[0], grade + (grade2));
        }

        String[][] array = new String[students.size()][2];
        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            array[i][0] = students.get(i);
            double division = studentsToAmountOfGrades.get(array[i][0]);
            array[i][1] = df.format(studentsToGrades.get(array[i][0]) / division);
        }
        return array;
    }
}