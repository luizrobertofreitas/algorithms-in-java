package org.algorithms.other;

import org.algorithms.others.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.algorithms.utils.ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY;

class TreesTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16"
    })
    void generateTreeFromOrderedArrayTest(String input) {
        Integer[] arr = CONVERT_STRING_TO_INTEGER_ARRAY.apply(input);
        Trees.Tree result = Trees.GENERATE_TREE_FROM_ORDERED_ARRAY.apply(arr);
        Assertions.assertNotNull(result.value());
        Assertions.assertNotNull(result.left());
        Assertions.assertNotNull(result.right());
        Integer[] resultConvertedIntoArray = result.asArray();
        System.out.println(Arrays.toString(resultConvertedIntoArray));
        Assertions.assertEquals(Arrays.toString(arr), Arrays.toString(resultConvertedIntoArray));
    }
}
