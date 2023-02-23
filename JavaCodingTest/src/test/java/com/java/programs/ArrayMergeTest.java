package com.java.programs;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class ArrayMergeTest extends TestCase {
    ArrayMerge arrayMerge = new ArrayMerge();
    public void testMergeArrayUsingHashSet() {
        Integer [] array1 = {1,2,2,1};
        Integer [] array2 = {2,2};
        Integer [] resultSet = arrayMerge.mergeArrayUsingHashSet(array1, array2);
        assertEquals(1, resultSet.length);
        assertArrayEquals(new Integer [] {2}, resultSet);
        System.out.println(Arrays.toString(resultSet));

        Integer []  nums1 = {4,9,5};
        Integer [] nums2 = {9,4,9,8,4};

        Integer [] resultSet_1 = arrayMerge.mergeArrayUsingHashSet(nums1, nums2);
        assertEquals(2, resultSet_1.length);
        assertArrayEquals(new Integer [] {4,9}, resultSet_1);
        System.out.println(Arrays.toString(resultSet_1));

        Integer [] num_3 = {};
        Integer [] num_4 = {};

        Integer [] result_2 = arrayMerge.mergeArrayUsingHashSet(num_3, num_4);
        assertEquals(0, result_2.length);
        assertArrayEquals(new Integer [] {}, result_2);
        System.out.println(Arrays.toString(result_2));

        Integer [] result_4 = arrayMerge.mergeArrayUsingHashSet(null, null);
        assertEquals(0,result_4.length);
        assertArrayEquals(new Integer [] {}, result_4);
    }

    public void testMergeArrayTest() {
        Integer [] array1 = {1,2,2,1};
        Integer [] array2 = {2,2};

        Integer [] result_1 = arrayMerge.mergeArray(array1, array2);
        assertEquals(1,result_1.length);
        assertArrayEquals(new Integer [] {2}, result_1);
        System.out.println(Arrays.toString(result_1));

        Integer []  num_1 = {4,9,5};
        Integer [] num_2 = {9,4,9,8,4};

        Integer [] result_2 = arrayMerge.mergeArray(num_1, num_2);
        assertEquals(2,result_2.length);
        assertArrayEquals(new Integer [] {4, 9}, result_2);
        System.out.println(Arrays.toString(result_2));

        Integer [] num_3 = {};
        Integer [] num_4 = {};

        Integer [] result_3 = arrayMerge.mergeArray(num_3, num_4);
        assertEquals(0,result_3.length);
        assertArrayEquals(new Integer [] {}, result_3);
        System.out.println(Arrays.toString(result_3));

        Integer [] result_4 = arrayMerge.mergeArray(null, null);
        assertEquals(0,result_4.length);
        assertArrayEquals(new Integer [] {}, result_4);
    }
}