package test;

import code.AnagramFinder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramFinderTest {

    //T1 (Base case)
    @Test
    void testBaseCase() {
        List<String> list1 = Arrays.asList("listen", "hello", "enlist");
        List<String> list2 = Arrays.asList("silent", "world", "tinsel");
        List<String> expected = Arrays.asList("listen", "enlist", "silent", "tinsel");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T2
    @Test
    void testEmptyLists() {
        List<String> list1 = Arrays.asList();
        List<String> list2 = Arrays.asList();
        List<String> expected = Arrays.asList();
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T3
    @Test
    void testUpperCaseHandling() {
        List<String> list1 = Arrays.asList("LISTEN", "HELLO", "ENLIST");
        List<String> list2 = Arrays.asList("SILENT", "WORLD", "TINSEL");
        List<String> expected = Arrays.asList("LISTEN", "ENLIST", "SILENT", "TINSEL");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T4
    @Test
    void testLargeList() {
        List<String> list1 = Arrays.asList("cat", "act", "tac", "dog", "god");
        List<String> list2 = Arrays.asList("ogd", "tca", "cta", "random", "words");
        List<String> expected = Arrays.asList("cat", "act", "tac", "dog", "god", "ogd", "tca", "cta");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T5
    @Test
    void testSpecialCharacters() {
        List<String> list1 = Arrays.asList("h@t", "th@");
        List<String> list2 = Arrays.asList("@ht", "random");
        List<String> expected = Arrays.asList();
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T6
    @Test
    void testAllAnagrams() {
        List<String> list1 = Arrays.asList("abc", "bca", "cab");
        List<String> list2 = Arrays.asList("cba", "bac", "acb");
        List<String> expected = Arrays.asList("abc", "bca", "cab", "cba", "bac", "acb");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T7
    @Test
    void testMediumLowercaseWordsSomeInOneListSameLengthDependsOnDuplicates() {
        List<String> list1 = Arrays.asList("listen", "enlist", "hello", "silent", "listen");
        List<String> list2 = Arrays.asList("silent", "tinsel", "enlist", "world", "hello");
        List<String> expected = Arrays.asList("listen", "enlist", "silent", "tinsel", "hello");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T8
    @Test
    void testMediumLowercaseWordsSomeInBothListsSameLengthDependsOnDuplicates() {
        List<String> list1 = Arrays.asList("listen", "hello", "silent", "listen", "enlist");
        List<String> list2 = Arrays.asList("silent", "tinsel", "enlist", "listen", "world");
        List<String> expected = Arrays.asList("listen", "enlist", "silent", "tinsel");
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }

    //T9
    @Test
    void testDifferentLengths() {
        List<String> list1 = Arrays.asList("abc", "hello");
        List<String> list2 = Arrays.asList("abcd", "world");
        List<String> expected = Arrays.asList();
        assertEquals(expected, AnagramFinder.findAnagrams(list1, list2));
    }
}