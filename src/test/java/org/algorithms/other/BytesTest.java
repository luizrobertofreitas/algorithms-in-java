package org.algorithms.other;

import org.junit.jupiter.api.Test;

class BytesTest {

    @Test
    void test() {
        final byte open = 1 << 2;
        final byte connectedToTop = 1 << 1;
        final byte connectedToBottom = 1;
        final byte conduct = connectedToTop | connectedToBottom | open;

        System.out.println("Open: " + open);
        System.out.println("Connected to Top: " + connectedToTop);
        System.out.println("Connected to Bottom: " + connectedToBottom);
        System.out.println("Conduct: " + conduct);
    }
}
