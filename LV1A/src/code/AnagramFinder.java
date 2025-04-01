package code;

import java.util.*;

public class AnagramFinder {
    public static List<String> findAnagrams(List<String> list1, List<String> list2) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        processList(list1, anagramGroups);
        processList(list2, anagramGroups);
        List<String> result = new ArrayList<>();
        for (List<String> group : anagramGroups.values()) {
            if (group.size() > 1) {
                result.addAll(group);
            }
        }
        return result;
    }

    private static void processList(List<String> list, Map<String, List<String>> anagramGroups) {
        for (String word : list) {
            String sortedKey = getSortedKey(word);
            anagramGroups.putIfAbsent(sortedKey, new ArrayList<>());
            if (!anagramGroups.get(sortedKey).contains(word)) {
                anagramGroups.get(sortedKey).add(word);
            }
        }
    }

    private static String getSortedKey(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
