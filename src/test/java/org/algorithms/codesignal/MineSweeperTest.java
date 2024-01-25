package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.algorithms.utils.ArrayCrazyOps.FLATTEN_INTEGER_MATRIX;

class MineSweeperTest {

    @Test
    void test1() {
        assertOk(
                new Integer[][] {
                        {1,2,1},
                        {2,1,1},
                        {1,1,1}
                },
                new Boolean[][] {
                        {true,false,false},
                        {false,true,false},
                        {false,false,false}
                }
        );
    }

    @Test
    void test2() {
        assertOk(
                new Integer[][] {
                        {0,0,0},
                        {0,0,0}
                },
                new Boolean[][] {
                        {false,false,false},
                        {false,false,false},
                }
        );
    }

    @Test
    void test3() {
        assertOk(
                new Integer[][] {
                        {0,0,0},
                        {0,0,0}
                },
                new Boolean[][] {
                        {false,false,false},
                        {false,false,false}
                }
        );
    }

    @Test
    void test4() {
        assertOk(
                new Integer[][] {
                        {0,2,2,1},
                        {3,4,3,3},
                        {1,2,3,1}
                },
                new Boolean[][] {
                        {true,false,false,true},
                        {false,false,true,false},
                        {true,true,false,true}
                }
        );
    }

    @Test
    void test5() {
        assertOk(
                new Integer[][] {
                        {3,5,3},
                        {5,8,5},
                        {3,5,3}
                },
                new Boolean[][] {
                        {true,true,true},
                        {true,true,true},
                        {true,true,true}
                }
        );
    }

    @Test
    void test6() {
        assertOk(
                new Integer[][] {
                        {3,3,3,2},
                        {2,4,5,2},
                        {2,3,2,2}
                },
                new Boolean[][] {
                        {false,true,true,false},
                        {true,true,false,true},
                        {false,false,true,false}
                }
        );
    }

    @Test
    void test7() {
        assertOk(
                new Integer[][] {
                        {1,2},
                        {2,3},
                        {2,1},
                        {1,1},
                        {0,0}
                },
                new Boolean[][] {
                        {true,false},
                        {true,false},
                        {false,true},
                        {false,false},
                        {false,false}
                }
        );
    }

    private void assertOk(Integer[][] expected, Boolean[][] matrix) {
        final Integer[][] result = MineSweeper.GENERATE_PROXIMITY.apply(matrix);
        Assertions.assertEquals(
                Arrays.toString(FLATTEN_INTEGER_MATRIX.apply(expected)),
                Arrays.toString(FLATTEN_INTEGER_MATRIX.apply(result))
        );
    }
}
