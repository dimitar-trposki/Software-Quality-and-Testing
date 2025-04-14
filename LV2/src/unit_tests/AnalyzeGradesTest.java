package unit_tests;

import method_code.AnalyzeGrades;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnalyzeGradesTest {
    @Test
    public void testNoStudentsPassedEmptyList() {
        int[] grades = {};
        String result = AnalyzeGrades.analyzeGrades(grades);
        assertEquals("No students passed.", result);
    }

    @Test
    public void testInvalidGrades() {
        int[] grades = {50, 60, -10, 110};
        String result = AnalyzeGrades.analyzeGrades(grades);
        assertEquals("Invalid grades detected.", result);
    }

    @Test
    public void testNoStudentsPassed() {
        int[] grades = {40, 30, 20};
        String result = AnalyzeGrades.analyzeGrades(grades);
        assertEquals("No students passed.", result);
    }

    @Test
    public void testAllStudentsPassed() {
        int[] grades = {50, 60, 70, 100};
        String result = AnalyzeGrades.analyzeGrades(grades);
        assertEquals("All students passed.", result);
    }

    @Test
    public void testSomeStudentsPassed() {
        int[] grades = {50, 40, 60, 51, 100};
        String result = AnalyzeGrades.analyzeGrades(grades);
        assertEquals("Some students passed.", result);
    }
}
