package test.processor;

import main.processor.DataProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    @Test
    public void testFindPrimes() {
        List<Integer> primes = dataProcessor.findPrimes(10, 20);
        List<Integer> expectedPrimes = Arrays.asList(11, 13, 17, 19);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimeSingleNumber() {
        List<Integer> primes = dataProcessor.findPrimes(2, 2);
        List<Integer> expectedPrimes = Arrays.asList(2);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesNoPrimes() {
        List<Integer> primes = dataProcessor.findPrimes(15, 16);
        assertTrue(primes.isEmpty());
    }

    @Test
    public void testFindPrimesLowerBound() {
        List<Integer> primes = dataProcessor.findPrimes(1, 10);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesUpperBound() {
        List<Integer> primes = dataProcessor.findPrimes(90, 100);
        List<Integer> expectedPrimes = Arrays.asList(97);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesEmptyRange() {
        List<Integer> primes = dataProcessor.findPrimes(15, 14);
        assertTrue(primes.isEmpty());
    }

    // Tests for string permutations
    @Test
    public void testGetPermutations() {
        Set<String> permutations = dataProcessor.getPermutations("abc");
        Set<String> expectedPermutations = new HashSet<>(Arrays.asList(
                "abc",
                "acb",
                "bac",
                "bca",
                "cab",
                "cba"
        ));
        assertEquals(expectedPermutations, permutations);
    }


    // Tests for depth-first search in a graph
    @Test
    public void testDepthFirstSearch() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(5));
        Set<Integer> visited = new HashSet<>();
        dataProcessor.depthFirstSearch(graph, 1, visited);
        Set<Integer> expectedVisited = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expectedVisited, visited);
    }

    @Test
    public void testDepthFirstSearchSelfLoop() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(1));
        Set<Integer> visited = new HashSet<>();
        dataProcessor.depthFirstSearch(graph, 1, visited);
        assertEquals(Collections.singleton(1), visited);
    }

    // Tests for linked list reversal
    @Test
    public void testReverseLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        LinkedList<Integer> reversed = dataProcessor.reverseLinkedList(list);
        LinkedList<Integer> expectedReversed = new LinkedList<>(Arrays.asList(3, 2, 1));
        assertEquals(expectedReversed, reversed);
    }

    @Test
    public void testReverseEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> reversed = dataProcessor.reverseLinkedList(list);
        assertTrue(reversed.isEmpty());
    }

    @Test
    public void testReverseLinkedListOneElement() {
        LinkedList<Integer> list = new LinkedList<>(Collections.singletonList(1));
        LinkedList<Integer> reversed = dataProcessor.reverseLinkedList(list);
        assertEquals(list, reversed);
    }

    @Test
    public void testReverseLinkedListLargeList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        LinkedList<Integer> reversed = dataProcessor.reverseLinkedList(list);
        assertEquals(1000, reversed.size());
    }

    // Tests for longest common subsequence
    @Test
    public void testLongestCommonSubsequence() {
        String s1 = "ABCBDAB";
        String s2 = "BDCAB";
        assertEquals(4, dataProcessor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceEmptyStrings() {
        String s1 = "";
        String s2 = "";
        assertEquals(0, dataProcessor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceIdenticalStrings() {
        String s1 = "ABCDE";
        String s2 = "ABCDE";
        assertEquals(5, dataProcessor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceAllDifferent() {
        String s1 = "ABC";
        String s2 = "XYZ";
        assertEquals(0, dataProcessor.longestCommonSubsequence(s1, s2));
    }

    // Tests for factorial method
    @Test
    public void testFactorial() {
        assertEquals(120, dataProcessor.factorial(5));
        assertEquals(1, dataProcessor.factorial(0));
    }

    @Test
    public void testFactorialNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> dataProcessor.factorial(-5));
    }

    // Tests for finding the missing number in an array
    @Test
    public void testFindMissingNumber() {
        int[] nums = {1, 2, 4, 5};
        assertEquals(3, dataProcessor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberSingleElement() {
        int[] nums = {1};
        assertEquals(2, dataProcessor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberAllButOne() {
        int[] nums = {1, 2, 4, 5, 6};
        assertEquals(3, dataProcessor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberConsecutive() {
        int[] nums = {1, 2, 3};
        assertEquals(4, dataProcessor.findMissingNumber(nums));
    }

    // Tests for matrix transpose
    @Test
    public void testTransposeMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] transposed = dataProcessor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 4}, {2, 5}, {3, 6}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeMatrixSingleRow() {
        int[][] matrix = {{1, 2, 3}};
        int[][] transposed = dataProcessor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1}, {2}, {3}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeMatrixSingleColumn() {
        int[][] matrix = {{1}, {2}, {3}};
        int[][] transposed = dataProcessor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 2, 3}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeSquareMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] transposed = dataProcessor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 3}, {2, 4}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    // Tests for unique characters in string
    @Test
    public void testCountUniqueCharacters() {
        assertEquals(2, dataProcessor.countUniqueCharacters("aab"));
        assertEquals(4, dataProcessor.countUniqueCharacters("abcd"));
        assertEquals(1, dataProcessor.countUniqueCharacters("aaaa"));
        assertEquals(6, dataProcessor.countUniqueCharacters("abc123"));
    }

}
