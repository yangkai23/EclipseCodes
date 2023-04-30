package conceptual;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] result = new double[studentIdList.length];
        int i = 0;
        for (char[] row : studentsGrades) {
            double gpa = 0.0;
            for (char grade : row) {

                switch (grade) {
                    case 'A':
                        gpa += 4.0;
                        break;
                    case 'B':
                        gpa += 3.0;
                        break;
                    case 'C':
                        gpa += 2.0;
                        break;
                }
            }
            result[i++] = gpa / row.length;
        }

        return result;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) return null;

        double[] gpa = calculateGPA(studentIdList, studentsGrades);
        System.out.println(Arrays.toString(gpa));
        int count = (int) (Arrays.stream(gpa).filter(i -> i > lower && i < higher).count());
        int[] result = new int[count];
        int pos = 0;
        outer:
        for (int i = 0; i < gpa.length; i++) {
            if (gpa[i] > lower && gpa[i] < higher) result[pos++] = studentIdList[i];

        }
        return result;

    }

    public static void print2DArray(char[][] array) {
        System.out.println("{");
        for (char[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students1");
        int studentIdList[] = new int[scanner.nextInt()];

        for (int i = 0; i < studentIdList.length; i++) {
            studentIdList[i] = scanner.nextInt();
        }
        char[][] studentGrades = new char[studentIdList.length][];
        outer:
        for (int i = 0; i < studentGrades.length; i++) {
            System.out.println("Enter number of grades for student id and grades to follow " + studentIdList[i]);
            int numOfGrades = scanner.nextInt();
            char[] grades = new char[numOfGrades];
            inner:
            for (int j = 0; j < numOfGrades; j++) {
                grades[j] = scanner.next().charAt(0);
            }
            studentGrades[i] = grades;
        }
        print2DArray(studentGrades);
        System.out.println("Enter lower Range ");
        double lower = scanner.nextDouble();
        System.out.println("Enter upper Range ");
        double upper = scanner.nextDouble();
        int[] result = getStudentsByGPA(lower, upper, studentIdList, studentGrades);
        System.out.println(Arrays.toString(result));
        scanner.close();
    }
}