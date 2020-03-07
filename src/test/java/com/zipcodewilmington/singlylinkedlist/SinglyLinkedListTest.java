package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest<E> {

    SinglyLinkedList<String> linkedList;
    SinglyLinkedList<Integer> intList;

    @Before
    public void setup() {
        linkedList = new SinglyLinkedList();
        intList = new SinglyLinkedList<>();
    }

    // Add Tests
    //=====================================================================================
    @Test
    public void addTest() throws Exception {
        // Given
        String expected1 = "first";
        String expected2 = "second";

        // When
        linkedList.add(expected1);
        linkedList.add(expected2);
        String actual1 = linkedList.get(0);
        String actual2 = linkedList.get(1);

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    // Remove Tests
    //=====================================================================================
    @Test
    public void removeFirstElementTest() throws Exception {
        // Given
        linkedList.add("yo");
        linkedList.add("bro");
        String expectedHead = "bro";
        int expectedSize = 1;
        int expectedFindYo = -1;
        int expectedFindBro = 0;

        // When
        linkedList.remove("yo");
        String actualHead = linkedList.getHead().getElement();
        int actualSize = linkedList.size();
        int actualFindYo = linkedList.find("yo");
        int actualFindBro = linkedList.find("bro");

        // Then
        Assert.assertEquals(expectedHead, actualHead);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedFindYo, actualFindYo);
        Assert.assertEquals(expectedFindBro, actualFindBro);
    }

    @Test
    public void removeLastElementTest() throws Exception {
        // Given
        intList.add(1);
        intList.add(2);

        int expectedSize = 1;
        int expectedFind3 = -1;

        // When
        intList.remove(2);
        int actualSize = intList.size();
        int actualFind3 = intList.find(2);

        // Then
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedFind3, actualFind3);
        Assert.assertNull(intList.getHead().getNext());
    }

    @Test
    public void removeMiddleElementTest() throws Exception {
        // Given
        linkedList.add("first");
        linkedList.add("middle");
        linkedList.add("last");
        String expectedHeadNext = "last";
        int expectedSize = 2;

        // When
        linkedList.remove("middle");
        String actualHeadNext = linkedList.getHead().getNext().getElement();
        int actualSize = linkedList.size();

        // Then
        Assert.assertEquals(expectedHeadNext, actualHeadNext);
        Assert.assertEquals(expectedSize, actualSize);
    }


    @Test(expected = Exception.class)
    public void removeFromEmptyListTest() throws Exception {
        // When
        linkedList.remove("meFromClass");
    }

    @Test(expected = Exception.class)
    public void removeNotPresentElementTest() throws Exception {
        // Given
        linkedList.add("bananas");

        // When
        linkedList.remove("apples");
    }

    // Contains Tests
    //=====================================================================================
    @Test
    public void emptyContainsTest() throws Exception {
        // When
        boolean actual = linkedList.contains("false");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void nonEmptyContainsTest() throws Exception {
        // Given
        String expectedTrue = "true";
        String expectedFalse = "false";
        linkedList.add("these exist");
        linkedList.add(expectedTrue);

        // When
        boolean actualTrue = linkedList.contains(expectedTrue);
        boolean actualFalse = linkedList.contains(expectedFalse);

        // Then
        Assert.assertTrue(actualTrue);
        Assert.assertFalse(actualFalse);
    }

    // Find Tests
    //=====================================================================================
    @Test
    public void emptyFindTest() throws Exception {
        // Given
        int expected = -1;

        // When
        int actual = linkedList.find("not here");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsElementFindTest() throws Exception {
        // Given
        intList.add(10);
        int expected1 = 0;
        intList.add(20);
        int expected2 = 1;

        // When
        int actual1 = intList.find(10);
        int actual2 = intList.find(20);

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void doesNotContainElementFindTest() throws Exception {
        // Given
        linkedList.add("these");
        linkedList.add("things");
        int expected = -1;

        // When
        int actual = linkedList.find("ghost");

        // Then
        Assert.assertEquals(expected, actual);
    }

    // Get Tests
    //=====================================================================================
    @Test(expected = Exception.class)
    public void emptyListGetTest() throws Exception {
        // Given
        linkedList.get(0);
    }

    @Test
    public void nonEmptyListGetTest() throws Exception {
        // Given
        Integer expected1 = 10;
        Integer expected2 = 20;
        intList.add(expected1);
        intList.add(expected2);

        // When
        Integer actual1 = intList.get(0);
        Integer actual2 = intList.get(1);

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test(expected = Exception.class)
    public void invalidIndexGetTest() throws Exception {
        // Given
        intList.add(10);
        intList.add(3);

        // When
        linkedList.get(2);
    }

    // Size
    //=====================================================================================
    @Test
    public void emptySizeTest() {
        // Given
        int expected = 0;

        // When
        int actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void nonEmptySizeTest() {
        // Given
        linkedList.add("uno");
        linkedList.add("dos");
        int expected = 2;

        // When
        int actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    // Copy Tests
    //=====================================================================================
    @Test
    public void copyEmptyTest(){
        // Given
        int expectedSize = 0;

        // When
        SinglyLinkedList<String> copy = linkedList.copy();
        int actualSize = copy.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertNull(copy.getHead());
        Assert.assertNotEquals(linkedList, copy);
    }

    @Test
    public void copyTest(){
        // Given
        String expected1 = "make";
        String expected2 = "copy";
        linkedList.add(expected1);
        linkedList.add(expected2);
        int expectedSize = 2;

        // When
        SinglyLinkedList<String> copy = linkedList.copy();
        int actualSize = copy.size();
        String actual1 = linkedList.getHead().getElement();
        String actual2 = linkedList.getHead().getNext().getElement();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expectedSize, actualSize);
    }

    // Sort Tests
    //=====================================================================================
    @Test
    public void sortOneElementTest(){
        // Given
        linkedList.add("sad");
        SinglyLinkedList.Node expectedHead = linkedList.getHead();

        // When
        linkedList.sort();
        SinglyLinkedList.Node actualHead = linkedList.getHead();

        // Then
        Assert.assertEquals(expectedHead, actualHead);
    }

    @Test
    public void sortStringsTest() throws Exception {
        // Given
        linkedList.add("sort");
        linkedList.add("god");
        linkedList.add("oh");
        int expectedFindGod = 0;
        int expectedFindOh = 1;
        int expectedFindSort = 2;

        // When
        linkedList.sort();
        int actualFindGod = linkedList.find("god");
        int actualFindOh = linkedList.find("oh");
        int actualFindSort = linkedList.find("sort");

        // Then
        Assert.assertEquals(expectedFindGod, actualFindGod);
        Assert.assertEquals(expectedFindOh, actualFindOh);
        Assert.assertEquals(expectedFindSort, actualFindSort);
    }

    @Test
    public void sortIntegersTest() throws Exception {
        // Given
        intList.add(3);
        intList.add(5);
        intList.add(1);
        int expectedFind1 = 0;
        int expectedFind3 = 1;
        int expectedFind5 = 2;

        // When
        intList.sort();
        int actualFind1 = intList.find(1);
        int actualFind3 = intList.find(3);
        int actualFind5 = intList.find(5);

        // Then
        Assert.assertEquals(expectedFind1, actualFind1);
        Assert.assertEquals(expectedFind3, actualFind3);
        Assert.assertEquals(expectedFind5, actualFind5);
    }

}

