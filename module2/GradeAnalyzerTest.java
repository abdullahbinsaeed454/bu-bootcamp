import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GradeAnalyzerTest {
    @Test
    void testAverage_typicalScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80); scores.add(90); scores.add(100);
        assertEquals(90.0, GradeAnalyzer.average(scores), 0.001);
    }

    @Test
    void testAverage_singleScore() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(75);
        assertEquals(75.0, GradeAnalyzer.average(scores), 0.001);
    }

    @Test
    void testHighest() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(60); scores.add(95); scores.add(72);
        assertEquals(95, GradeAnalyzer.highest(scores));
    }

    @Test
    void testLowest() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(60); scores.add(95); scores.add(72);
        assertEquals(60, GradeAnalyzer.lowest(scores));
    }

    @Test
    void testLetterGrade_boundaries() {
        assertEquals('A', GradeAnalyzer.letterGrade(95));
        assertEquals('B', GradeAnalyzer.letterGrade(85));
        assertEquals('C', GradeAnalyzer.letterGrade(75));
        assertEquals('D', GradeAnalyzer.letterGrade(65));
        assertEquals('F', GradeAnalyzer.letterGrade(50));
    }

    @Test
    void testAverage_tenScoresExactValue() {
        ArrayList<Integer> scores = new ArrayList<>();
        int[] values = {70, 75, 80, 85, 90, 95, 100, 65, 60, 100};
        for (int v : values) scores.add(v);
        assertEquals(82.0, GradeAnalyzer.average(scores), 0.001);
    }

    @Test
    void testReadScores_fromFile(@TempDir Path tempDir) throws IOException, FileNotFoundException {
        File tempFile = tempDir.resolve("test_scores.txt").toFile();
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("88\n92\n74\n");
        }
        ArrayList<Integer> scores = GradeAnalyzer.readScores(tempFile.getAbsolutePath());
        assertEquals(3, scores.size());
        assertEquals(88, scores.get(0));
        assertEquals(92, scores.get(1));
        assertEquals(74, scores.get(2));
    }
}