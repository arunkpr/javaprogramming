package com.java.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class ArrayMerge {
    /**
     * function to compute arrays intersection
     * @param array1
     * @param array2
     * @return
     */
    public Integer[] mergeArray(Integer [] array1, Integer [] array2){
        Set<Integer> resultSet = new HashSet<>();
        if (array1!=null && array2!=null) {
            for (int i=0; i <array1.length; i++) {
                for (int j=0 ;j<array2.length; j++){
                    if (array1[i] == array2[j]) {
                        resultSet.add(array1[i]);
                    }
                }
            }}
        return resultSet.stream().toArray(Integer[]::new);
    }
    /**
     * function to compute arrays intersection using set operation
     * @param array1 Integer array 1
     * @param array2 Integer array 2
     * @return
     */
    public Integer[] mergeArrayUsingHashSet(Integer [] array1, Integer [] array2) {
        if (array1 != null && array2 != null) {
            Set<Integer> set1 = Arrays.stream(array1).collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(array2).collect(Collectors.toSet());
            set1.retainAll(set2);
            Integer[] result = set1.stream().toArray(Integer[]::new);
            return result;
        }
        return new Integer[]{};
    }
}
