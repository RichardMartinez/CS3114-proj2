import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import student.TestCase;
import student.TestableRandom;

/**
 * This class tests the methods of SkipList class
 * 
 * @author CS Staff
 * 
 * @version 2024-01-22
 */

public class SkipListTest extends TestCase {

    private SkipList<String, Point> sl;

    /**
     * Set up new SkipList for each test
     */
    public void setUp() {
        sl = new SkipList<String, Point>();
    }


    /***
     * Example 1: Test `randomLevel` method with
     * predetermined random values using `TestableRandom`
     */
    public void testRandomLevelOne() {
        TestableRandom.setNextBooleans(false);
        sl = new SkipList<String, Point>();
        int randomLevelValue = sl.randomLevel();

        // This returns 1 because the first preset
        // random boolean is `false` which breaks
        // the `while condition inside the `randomLevel` method
        int expectedLevelValue = 1;

        // Compare the values
        assertEquals(expectedLevelValue, randomLevelValue);
    }


    /***
     * Example 2: Test `randomLevel` method with
     * predetermined random values using `TestableRandom`
     */
    public void testRandomLevelFour() {
        TestableRandom.setNextBooleans(true, true, true, false, true, false);
        sl = new SkipList<String, Point>();
        int randomLevelValue = sl.randomLevel();

        // This returns 4 because the fourth preset
        // random boolean is `false` which breaks
        // the `while condition inside the `randomLevel` method
        int expectedLevelValue = 4;

        // Compare the values
        assertEquals(expectedLevelValue, randomLevelValue);
    }


    /**
     * Test inserting two rectangles
     * and verify they are there
     */
    public void testInsert() {
        // Reset Testable Random
        TestableRandom.setNextBooleans(null);

        // sl is a default constructed SkipList
        Point pt = new Point(10, 10);
        String name = "HelloWorld";
        KVPair<String, Point> pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(20, 20);
        name = "HelloWorld2";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        // Iterator and Test KVPairs
        Iterator<KVPair<String, Point>> it = sl.iterator();

        KVPair<String, Point> elem;
        elem = it.next();
        assertEquals(elem.getKey(), "HelloWorld");
        elem = it.next();
        assertEquals(elem.getKey(), "HelloWorld2");
    }


    /**
     * Test the dump method prints
     * as expected
     */
    public void testDump() {
        // Make next levels: 3, 2
        TestableRandom.setNextBooleans(true, true, false, true, false);

        // sl is a default constructed SkipList
        Point pt = new Point(1, 0);
        String name = "a";
        KVPair<String, Point> pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(2, 0);
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        String expectedOutput = "SkipList dump:\n"
            + "Node with depth 3, Value null\n"
            + "Node with depth 3, Value (a, 1, 0)\n"
            + "Node with depth 2, Value (b, 2, 0)\n" + "SkipList size is: 2\n";

        systemOut().clearHistory();
        sl.dump();

        String actualOutput = systemOut().getHistory();
        assertFuzzyEquals(expectedOutput, actualOutput);
    }


    /**
     * Test the dump method works
     * as expected with an empty list
     */
    public void testEmptyListDump() {
        String expectedOutput = "SkipList dump:\n"
            + "Node with depth 1, Value null\n" + "SkipList size is: 0\n";

        systemOut().clearHistory();
        sl.dump();

        String actualOutput = systemOut().getHistory();
        assertFuzzyEquals(expectedOutput, actualOutput);
    }


    /**
     * Test inserting null values
     * as last value in list
     */
    public void testInsertNullValues() {
        // Make next levels: 3, 2
        TestableRandom.setNextBooleans(null);

        // sl is a default constructed SkipList
        Point pt = new Point(1, 0);
        String name = "a";
        KVPair<String, Point> pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = null;
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        // Iterator and Test KVPairs
        Iterator<KVPair<String, Point>> it = sl.iterator();

        KVPair<String, Point> elem;
        elem = it.next();
        assertEquals(elem.getKey(), "a");
        assertNotNull(elem.getValue());
        elem = it.next();
        assertEquals(elem.getKey(), "b");
        assertNull(elem.getValue());
    }


    /**
     * Test the hasNext method of the iterator
     */
    public void testIteratorHasNext() {
        // Make next levels: 3, 2
        TestableRandom.setNextBooleans(true, true, false, true, false);

        // sl is a default constructed SkipList
        Point pt = new Point(1, 0);
        String name = "a";
        KVPair<String, Point> pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(2, 0);
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        // Iterator and Test KVPairs
        Iterator<KVPair<String, Point>> it = sl.iterator();

        KVPair<String, Point> elem;
        elem = it.next();
        assertEquals(elem.getKey(), "a");

        boolean hasNext = it.hasNext();
        assertTrue(hasNext);

        elem = it.next();
        assertEquals(elem.getKey(), "b");

        hasNext = it.hasNext();
        assertFalse(hasNext);
    }


    /**
     * Test the search method
     */
    public void testSearch() {
        // Reset Random
        TestableRandom.setNextBooleans(null);

        Point pt;
        String name;
        KVPair<String, Point> pair;

        pt = new Point(10, 10);
        name = "a";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(1, 2);
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(50, 21);
        name = "a";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        ArrayList<KVPair<String, Point>> list = sl.search("a");

        assertEquals(list.size(), 2);

        Iterator<KVPair<String, Point>> it = list.iterator();
        KVPair<String, Point> elem;
        elem = it.next();
        assertEquals(elem.getKey(), "a");
        elem = it.next();
        assertEquals(elem.getKey(), "a");

        assertFalse(it.hasNext());

        // Test search not found
        list = sl.search("c");

        assertEquals(list.size(), 0);
        it = list.iterator();
        assertFalse(it.hasNext());
    }


    /**
     * Test the remove by key method
     */
    public void testRemove() {
        // Set Random to be 1, 1, 2, 2
        TestableRandom.setNextBooleans(false, false, true, false, true, false);

        Point pt;
        String name;
        KVPair<String, Point> pair;

        pt = new Point(10, 10);
        name = "a";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(1, 2);
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(10, 20);
        name = "c";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(15, 25);
        name = "d";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        assertTrue(sl.size() == 4);

        KVPair<String, Point> success;

        success = sl.remove("b");
        assertNotNull(success);

        success = sl.remove("c");
        assertNotNull(success);

        assertTrue(sl.size() == 2);

        // Try to remove e (not in)
        success = sl.remove("e");
        assertNull(success);
        assertTrue(sl.size() == 2);
    }


    /**
     * Test removing all the elements
     */
    public void testRemoveAll() {
        // Set Random to be 1, 1, 2, 2
        TestableRandom.setNextBooleans(false, false, true, false, true, false);

        Point pt;
        String name;
        KVPair<String, Point> pair;

        pt = new Point(10, 10);
        name = "a";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(1, 2);
        name = "b";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(10, 20);
        name = "c";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        pt = new Point(15, 25);
        name = "d";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        System.out.println("BEFORE DUMP:");
        sl.dump();

        KVPair<String, Point> success;

        assertTrue(sl.size() == 4);

        success = sl.remove("a");
        assertNotNull(success);
        assertTrue(sl.size() == 3);

        success = sl.remove("b");
        assertNotNull(success);
        assertTrue(sl.size() == 2);

        success = sl.remove("c");
        assertNotNull(success);
        assertTrue(sl.size() == 1);

        success = sl.remove("d");
        assertNotNull(success);
        assertTrue(sl.size() == 0);

        System.out.println("AFTER DUMP:");
        sl.dump();
    }


    /**
     * Test a simple remove case
     */
    public void testSimpleRemove() {
        Point pt;
        String name;
        KVPair<String, Point> pair;

        assertTrue(sl.size() == 0);

        pt = new Point(10, 10);
        name = "a";
        pair = new KVPair<String, Point>(name, pt);
        sl.insert(pair);

        assertTrue(sl.size() == 1);

        KVPair<String, Point> success;

        success = sl.remove("a");
        assertNotNull(success);
        assertTrue(sl.size() == 0);
    }


    /**
     * Test searching an empty list returns
     * empty arraylist
     */
    public void testSearchEmptyList() {
        ArrayList<KVPair<String, Point>> list = sl.search("a");

        assertTrue(list.size() == 0);
    }

}
