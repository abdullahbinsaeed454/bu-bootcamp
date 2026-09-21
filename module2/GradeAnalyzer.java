import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeAnalyzer {

    static ArrayList<Integer> readScores(String filename) throws FileNotFoundException {
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                scores.add(Integer.parseInt(line));
            }
        }
        fileScanner.close();
        return scores;
    }

    static double average(ArrayList<Integer> scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return (double) sum / scores.size();
    }

    static int highest(ArrayList<Integer> scores) {
        int max = scores.get(0);
        for (int s : scores) {
            if (s > max) max = s;
        }
        return max;
    }

    static int lowest(ArrayList<Integer> scores) {
        int min = scores.get(0);
        for (int s : scores) {
            if (s < min) min = s;
        }
        return min;
    }

    static char letterGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        try {
            ArrayList<Integer> scores = readScores("scores.txt");
            if (scores.isEmpty()) {
                System.out.println("No scores found in file.");
                return;
            }
            double avg = average(scores);
            System.out.println("Number of scores: " + scores.size());
            System.out.printf("Average: %.2f%n", avg);
            System.out.println("Highest: " + highest(scores));
            System.out.println("Lowest: " + lowest(scores));
            System.out.println("Letter grade for average: " + letterGrade(avg));
        } catch (FileNotFoundException e) {
            System.out.println("Error: scores.txt not found. Run this from the module2 folder.");
        } catch (NumberFormatException e) {
            System.out.println("Error: scores.txt contains a non-numeric line.");
        }
    }
}
