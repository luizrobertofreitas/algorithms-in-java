package org.algorithms.algs4.module5.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class UngradedAssignmentTest {

    @ParameterizedTest
    @CsvSource(delimiterString = ";", value = {
        "10,9,5,4,0,1,7;0,1,12,14,16,4;3",
        "1,3,5,7,9,11,13;0,2,4,6,8,10,12;0",
        "1,3,5,7,9,11,13,15,17,19,21,23,25,27,29;2,4,6,8,10,11,13,15,17,19,20,22,24,26;5"
    })
    void smallIntersectSetsTest(String one, String two, Integer expected) {
        Set<Integer> s1 = Arrays.stream(one.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(two.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        Assertions.assertEquals(expected, UngradedAssignment.INTERSECT.apply(s1, s2).size());
    }

    @ParameterizedTest
    @CsvSource(delimiterString = ";", value = {
        "10,9,5,4,0,1,7;0,1,12,14,16,4;false",
        "1,3,5,7,9,11,13;0,2,4,6,8,10,12;false",
        "1,3,5,7,9,11,13,15,17,19,21,23,25,27,29;2,4,6,8,10,11,13,15,17,19,20,22,24,26;false",
        "1,2,3;3,1,2;true",
        "2,1,3;3,2,1;true",
        "1,2,3;3,1,1;false",
    })
    void smallArraysPermutationsTest(String one, String two, Boolean expected) {
        int[] a1 = Arrays.stream(one.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] a2 = Arrays.stream(two.split(",")).mapToInt(Integer::parseInt).toArray();
        Assertions.assertEquals(expected, UngradedAssignment.PERMUTATION.test(a1, a2));
    }
}
