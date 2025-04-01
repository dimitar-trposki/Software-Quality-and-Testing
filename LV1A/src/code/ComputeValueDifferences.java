package code;

import java.util.HashMap;
import java.util.Map;

public class ComputeValueDifferences {
    /**
     * Given two maps with string keys and integer values, return a new map containing only the keys that exist in both maps.
     * For each such key, the value should be the absolute difference of the two values from the input maps.
     * <p>
     * Example:
     * map1 = {"A": 5, "B": 10, "C": 3}
     * map2 = {"B": 7, "C": 8, "D": 12}
     * Output: {"B": 3, "C": 5}
     * <p>
     * If there are no common keys, return an empty map.
     */
    public static Map<String, Integer> computeValueDifferences(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1 == null || map2 == null) {
            throw new NullPointerException("Input maps must not be null.");
        }

        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer val1 = map1.get(key);
                Integer val2 = map2.get(key);

                if (val1 == null || val2 == null) {
                    throw new NullPointerException("Map values must not be null.");
                }

                result.put(key, Math.abs(val1 - val2));
            }
        }

        return result;
    }
}
