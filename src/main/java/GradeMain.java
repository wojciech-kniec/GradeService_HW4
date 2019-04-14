import java.util.Arrays;

public class GradeMain {
    public static void main(String[] args) {
        GradeService gradeService = new GradeService();
        System.out.println(Arrays.deepToString(gradeService.calculateAverage(new String[][]{
                {"Ania", "5"},
                {"Tomek", "6"},
                {"Kasia", "3"},
                {"Albert", "2"},
                {"Ania", "3"},
                {"Tomek", "1"},
                {"Tomek", "4"},
                {"Bartek", "2"}
        })));
    }
}
