package org.algorithms.codesignal;

import java.util.function.Predicate;

public final class IPv4AddressValidator {
    private IPv4AddressValidator() {}

    public static final Predicate<String> SOLUTION = input -> {
        String[] octets = input.split("\\.");
        if (octets.length != 4) return false;
        for (String o : octets) if (!isValidNumber(o)) {
            return false;
        }
        return true;
    };

    private static boolean isValidNumber(String octet) {
        try {
            int o = Integer.parseInt(octet);
            return (o != 0 || octet.length() <= 1) &&
                    (o <= 0 || !octet.startsWith("0")) &&
                    (o >= 0 && o <= 255);
        } catch (Exception e) {
            return false;
        }
    }
}
