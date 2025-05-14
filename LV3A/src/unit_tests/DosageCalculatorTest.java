package unit_tests;

import method_code.DosageCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DosageCalculatorTest {
    //RACC
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
