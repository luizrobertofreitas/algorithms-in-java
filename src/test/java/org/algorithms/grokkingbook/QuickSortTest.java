package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.algorithms.utils.ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY;

class QuickSortTest {

    @Timeout(1)
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,4,5,6;[1, 2, 3, 4, 5, 6]",
            "60,50,40,20,10,30;[10, 20, 30, 40, 50, 60]",
            "40,30,60,50,40,20,10,30,40;[10, 20, 30, 30, 40, 40, 40, 50, 60]",
            "50,0,66,80,67,62,5,2,56,13,22,78,91,58,38,52,53,21,20,23,18,77,4,10,76,31,14,65,16,55,43,82,83,29,25,88,96,6,39,69,46,48,27,34,74,17,44,49,15,97,59,93,84,7,28,8,45,24,12,64,60,33,63,35,71,89,40,54,92,94,81,26,95,42,68,36,72,98,79,32,75,51,87,11,99,37,9,57,70,1,61,90,85,3,41,86,30,73,47,19;[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]",
            "310,355,335,320,445,-25,45,30,95,105,-10,60,325,0,175,340,150,-35,380,430,35,250,40,20,405,130,235,230,385,350,70,65,375,315,305,220,395,290,165,360,205,275,155,110,225,15,345,295,5,160,200,100,-5,-30,210,420,-15,50,135,145,255,125,140,425,215,115,410,-45,280,25,440,240,75,365,300,330,180,400,90,-20,55,85,245,285,80,-50,390,265,170,260,120,-40,370,415,435,10,185,270,195,190;[-50, -45, -40, -35, -30, -25, -20, -15, -10, -5, 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215, 220, 225, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 290, 295, 300, 305, 310, 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365, 370, 375, 380, 385, 390, 395, 400, 405, 410, 415, 420, 425, 430, 435, 440, 445]"
    })
    void test(String input, String expectedResult) {
        Integer[] array = CONVERT_STRING_TO_INTEGER_ARRAY.apply(input);
        Integer[] result = QuickSort.SOLUTION.apply(array);
        Assertions.assertEquals(expectedResult, Arrays.toString(result));
    }

}
