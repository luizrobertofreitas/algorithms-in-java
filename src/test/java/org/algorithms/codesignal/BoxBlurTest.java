package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

class BoxBlurTest {

    @Test
    @Timeout(3)
    void test1() {
        assertEquals(
                new Integer[][] {{1}},
                new Integer[][] {
                        {1,1,1},
                        {1,7,1},
                        {1,1,1}
                }
        );
    }

    @Test
    @Timeout(3)
    void test2() {
        assertEquals(
                new Integer[][] {{28}},
                new Integer[][] {
                        {0,18,9},
                        {27,9,0},
                        {81,63,45}
                }
        );
    }

    @Test
    @Timeout(3)
    void test3() {
        assertEquals(
                new Integer[][] {{40,30}},
                new Integer[][] {
                        {36,0,18,9},
                        {27,54,9,0},
                        {81,63,72,45}
                }
        );
    }

    @Test
    @Timeout(3)
    void test4() {
        assertEquals(
                new Integer[][] {
                        {5,4},
                        {4,4}
                },
                new Integer[][] {
                        {7,4,0,1},
                        {5,6,2,2},
                        {6,10,7,8},
                        {1,4,2,0}
                }
        );
    }

    @Test
    @Timeout(3)
    void test5() {
        assertEquals(
                new Integer[][] {
                        {39,30,26,25,31},
                        {34,37,35,32,32},
                        {38,41,44,46,42},
                        {22,24,31,39,45},
                        {37,34,36,47,59}
                },
                new Integer[][] {
                        {36,0,18,9,9,45,27},
                        {27,0,54,9,0,63,90},
                        {81,63,72,45,18,27,0},
                        {0,0,9,81,27,18,45},
                        {45,45,27,27,90,81,72},
                        {45,18,9,0,9,18,45},
                        {27,81,36,63,63,72,81}
                }
        );
    }

    @Test
    @Timeout(3)
    void test6() {
        assertEquals(
                new Integer[][] {
                        {82,73,48,25,31},
                        {77,80,57,32,32},
                        {81,106,88,68,42},
                        {44,96,103,89,45},
                        {59,113,137,126,80}
                },
                new Integer[][] {
                        {36,0,18,9,9,45,27},
                        {27,0,254,9,0,63,90},
                        {81,255,72,45,18,27,0},
                        {0,0,9,81,27,18,45},
                        {45,45,227,227,90,81,72},
                        {45,18,9,255,9,18,45},
                        {27,81,36,127,255,72,81}
                }
        );
    }

    private void assertEquals(Integer[][] expected, Integer[][] image) {
        final Integer[][] result = BoxBlur.SOLUTION.apply(image);
        final String resultAsString = Arrays.stream(result).map(Arrays::toString).reduce("", (acc, a) -> acc + a + ",");
        final String expectedAsString = Arrays.stream(expected).map(Arrays::toString).reduce("", (acc, a) -> acc + a + ",");
        Assertions.assertEquals(expectedAsString, resultAsString);
    }
}
