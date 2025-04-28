package unit_tests;

import method_code.DosageCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DosageCalculatorTest {
    // Test case 1: High-risk patient with low weight and no allergy
    @Test
    public void testHighRiskPatientLowWeightNoAllergy() {
        double result1 = DosageCalculator.calculateDosage(70, 45, true, false);
        assertEquals(36.0, result1, 0.01);
    }

    // Test case 2: Non-high-risk patient with high weight and no allergy
    @Test
    public void testNonHighRiskPatientHighWeightNoAllergy() {
        double result2 = DosageCalculator.calculateDosage(30, 80, false, false);
        assertEquals(99.0, result2, 0.01);
    }

    // Test case 3: High-risk patient with high weight and allergy
    @Test
    public void testHighRiskPatientHighWeightAllergy() {
        double result3 = DosageCalculator.calculateDosage(65, 70, true, true);
        assertEquals(90.5, result3, 0.01);
    }

    // Test case 4: Non-high-risk patient with low weight and allergy
    @Test
    public void testNonHighRiskPatientLowWeightAllergy() {
        double result4 = DosageCalculator.calculateDosage(40, 50, false, true);
        assertEquals(64.0, result4, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "70, 45.0, false, false, 36.0", // age > 65, weight < 50, no allergy
            "60, 45.0, false, false, 60.0", // age <= 65, weight < 50, no allergy
            "60, 55.0, true, false, 72.0",  // weight >= 50
            "60, 45.0, true, false, 36.0",  // isHighRisk true
            "60, 45.0, true, true, 60.0"    // hasAllergy true
    })
    void testCalculateDosage(int age, double weight, boolean isHighRisk, boolean hasAllergy, double expected) {
        double dosage = DosageCalculator.calculateDosage(age, weight, isHighRisk, hasAllergy);
        assertEquals(expected, dosage, 0.001);
    }
}
