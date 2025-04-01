package test;

import code.ComputeValueDifferences;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ComputeValueDifferencesTest {
    // Base Test Case (BCC)
    @Test
    public void testBaseCase() {
        Map<String, Integer> map1 = Map.of("A", 5, "B", 10);
        Map<String, Integer> map2 = Map.of("B", 7, "C", 8);
        Map<String, Integer> expected = Map.of("B", 3);
        assertEquals(expected, ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    // Both Maps Empty
    @Test
    public void testBothMapsEmpty() {
        assertEquals(Collections.emptyMap(), ComputeValueDifferences.computeValueDifferences(Collections.emptyMap(), Collections.emptyMap()));
    }

    // One Map Empty
    @Test
    public void testFirstMapEmpty() {
        Map<String, Integer> map2 = Map.of("A", 5);
        assertEquals(Collections.emptyMap(), ComputeValueDifferences.computeValueDifferences(Collections.emptyMap(), map2));
    }

    @Test
    public void testSecondMapEmpty() {
        Map<String, Integer> map1 = Map.of("A", 5);
        assertEquals(Collections.emptyMap(), ComputeValueDifferences.computeValueDifferences(map1, Collections.emptyMap()));
    }

    // No Common Keys
    @Test
    public void testNoCommonKeys() {
        Map<String, Integer> map1 = Map.of("X", 3, "Y", 6);
        Map<String, Integer> map2 = Map.of("A", 4, "B", 7);
        assertEquals(Collections.emptyMap(), ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    // Common Keys with Equal Values (Result should be zero differences)
    @Test
    public void testEqualValuesForCommonKeys() {
        Map<String, Integer> map1 = Map.of("A", 10, "B", 10);
        Map<String, Integer> map2 = Map.of("A", 10, "B", 10);
        Map<String, Integer> expected = Map.of("A", 0, "B", 0);
        assertEquals(expected, ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    // Common Keys with Different Values
    @Test
    public void testDifferentValuesForCommonKeys() {
        Map<String, Integer> map1 = Map.of("A", 15, "B", 5);
        Map<String, Integer> map2 = Map.of("A", 10, "B", 8);
        Map<String, Integer> expected = Map.of("A", 5, "B", 3);
        assertEquals(expected, ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    // Large Integer Values
    @Test
    public void testLargeNumbers() {
        Map<String, Integer> map1 = Map.of("A", Integer.MAX_VALUE, "B", Integer.MAX_VALUE);
        Map<String, Integer> map2 = Map.of("A", Integer.MAX_VALUE - 1, "B", Integer.MAX_VALUE - 2);
        Map<String, Integer> expected = Map.of("A", 1, "B", 2);
        assertEquals(expected, ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    // Handling Null Maps
    @Test
    public void testNullFirstMap() {
        assertThrows(NullPointerException.class, () -> ComputeValueDifferences.computeValueDifferences(null, Map.of("A", 5)));
    }

    @Test
    public void testNullSecondMap() {
        assertThrows(NullPointerException.class, () -> ComputeValueDifferences.computeValueDifferences(Map.of("A", 5), null));
    }

    // Handling Null Values in Maps
    @Test
    public void testNullValueInFirstMap() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", null);
        Map<String, Integer> map2 = Map.of("A", 5);
        assertThrows(NullPointerException.class, () -> ComputeValueDifferences.computeValueDifferences(map1, map2));
    }

    @Test
    public void testNullValueInSecondMap() {
        Map<String, Integer> map1 = Map.of("A", 5);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("A", null);
        assertThrows(NullPointerException.class, () -> ComputeValueDifferences.computeValueDifferences(map1, map2));
    }
}
