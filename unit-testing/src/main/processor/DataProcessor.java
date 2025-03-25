package main.processor;

import java.util.*;

public class DataProcessor {

    private Map<String, Integer> dataMap;

    public DataProcessor() {
        dataMap = new HashMap<>();
    }

    /**
     * Fibonacci with memoization
     *
     * @param n
     * @param memo
     * @return
     */
    public int fibonacci(int n, Map<Integer, Integer> memo) {
        if (n < 0) throw new IllegalArgumentException("Negative input not allowed");
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    /**
     * Prime numbers in range
     *
     * @param start
     * @param end
     * @return
     */
    public List<Integer> findPrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, start); i <= end; i++) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

    /**
     * Prime check
     *
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * String permutations
     *
     * @param str
     * @return
     */
    public Set<String> getPermutations(String str) {
        Set<String> result = new HashSet<>();
        permute("", str, result);
        return result;
    }

    /**
     * Permutation helper function
     *
     * @param prefix
     * @param remaining
     * @param result
     */
    private void permute(String prefix, String remaining, Set<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(
                    prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    result
            );
        }
    }

    /**
     * DFS graph traversal
     *
     * @param graph
     * @param start
     * @param visited
     */
    public void depthFirstSearch(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
        if (visited.contains(start)) return;
        visited.add(start);
        for (int neighbor : graph.getOrDefault(start, new ArrayList<>())) {
            depthFirstSearch(graph, neighbor, visited);
        }
    }

    /**
     * Linked list reversal
     *
     * @param list
     * @return
     */
    public LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int item : list) {
            reversed.addFirst(item);
        }
        return reversed;
    }

    /**
     * Longest common subsequence
     *
     * @param s1
     * @param s2
     * @return
     */
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * Factorial
     *
     * @param n
     * @return
     */
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative input not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    /**
     * Missing number
     *
     * @param nums
     * @return
     */
    public int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
    }

    /**
     * Transpose a matrix
     *
     * @param matrix
     * @return
     */
    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    /**
     * Unique characters in string
     *
     * @param str
     * @return
     */
    public int countUniqueCharacters(String str) {
        return (int) str.chars().distinct().count();
    }
}