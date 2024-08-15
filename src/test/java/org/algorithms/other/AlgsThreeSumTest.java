package org.algorithms.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class AlgsThreeSumTest {

    @Test
    void test() {
        int[] n = new int[] {10, 20, 0, -40, 30};
        Arrays.sort(n);
        int count = 0;
        for (int i = 0; i < n.length; i++)
            for (int j = i+1; j < n.length; j++) {
                int found = Arrays.binarySearch(n, -(n[i] + n[j]));
                if (found == -1) continue;
                for (int k = j + 1; k < n.length; k++)
                    if (n[i] + n[j] + n[k] == 0 && n[i] < n[j] && n[j] < n[k])
                        count++;
            }

        Assertions.assertEquals(1, count);
    }

    @ParameterizedTest
    @CsvSource({
        "4,false",
        "7,true",
        "2,false",
        "1,true"
    })
    void bitonic(int number, boolean expected) {
        int[] n = new int[] { 1 , 3 , 5 , 7 , 5 , 3 , 1};
        boolean success = false;
        for (int i = 0 ; i <= n.length/2 ; i++) {
            if (n[i] == number) {
                success = true;
                break;
            }
        }
        Assertions.assertEquals(expected, success);
    }
}
