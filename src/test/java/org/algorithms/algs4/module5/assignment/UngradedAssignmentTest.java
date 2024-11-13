package org.algorithms.algs4.module5.assignment;

import org.algorithms.utils.ArrayCrazyOps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

class UngradedAssignmentTest {

    @ParameterizedTest
    @CsvSource(delimiterString = ";", value = {
        "10,9,5,4,0,1,7;0,1,12,14,16,4;0,1,4",
        "1,3,5,7,9,11,13;0,2,4,6,8,10,12;",
        "1,3,5,7,9,11,13,15,17,19,21,23,25,27,29;2,4,6,8,10,11,13,15,17,19,20,22,24,26;11,13,15,17,19"
    })
    void smallSetsTest(String one, String two, String expected) {
        Set<Integer> s1 = Arrays.stream(one.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(two.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> se = expected == null ?
            Collections.emptySet() :
            Arrays.stream(expected.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        Assertions.assertEquals(se, UngradedAssignment.INTERSECT.apply(s1, s2));
    }
}
