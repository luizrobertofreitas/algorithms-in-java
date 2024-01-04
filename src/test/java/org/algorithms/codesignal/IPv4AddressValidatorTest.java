package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IPv4AddressValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "172.16.254.1,true",
            "172.316.254.1,false",
            ".254.255.0,false",
            "1.1.1.1a,false",
            "1,false",
            "0.254.255.0,true",
            "1.23.256.255.,false",
            "1.23.256..,false",
            "0..1.0,false",
            "64.233.161.00,false",
            "64.00.161.131,false",
            "01.233.161.131,false",
            "35..36.9.9.0,false",
            "1.1.1.1.1,false",
            "1.256.1.1,false",
            "a0.1.1.1,false",
            "0.1.1.256,false",
            "129380129831213981.255.255.255,false",
            "255.255.255.255abcdekjhf,false",
            "7283728,false",
            "0..1.0.0,false",
    })
    void test(String input, Boolean expectedResult) {
        Assertions.assertEquals(expectedResult, IPv4AddressValidator.SOLUTION.test(input));
    }
}
