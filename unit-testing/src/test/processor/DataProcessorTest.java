package test.processor;

import main.processor.DataProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DataProcessorTest {

    private DataProcessor dataProcessor;

    @BeforeEach
    void setUp() {
        dataProcessor = new DataProcessor();
    }

    // Tests for Fibonacci method
    @Test
    public void testFibonacciBaseCase() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(0, dataProcessor.fibonacci(0, memo));
        assertEquals(1, dataProcessor.fibonacci(1, memo));
    }

    @Test
    public void testFibonacciRecursiveCase() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(5, dataProcessor.fibonacci(5, memo));
        assertEquals(21, dataProcessor.fibonacci(8, memo));
    }

    @Test
    public void testFibonacciEdgeCaseNegative() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> dataProcessor.fibonacci(-1, memo));
    }

    @Test
    public void testFibonacciLargeInput() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(832040, dataProcessor.fibonacci(30, memo));
    }

    // Tests for finding prime numbers in range
    
}
