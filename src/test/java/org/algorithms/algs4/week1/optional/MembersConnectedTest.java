package org.algorithms.algs4.week1.optional;

import org.algorithms.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MembersConnectedTest {
    @Test
    void test() {
        int seq = 1;
        var connections = List.of(
                new MembersConnected.Connection("Mary", "Mary", seq++),
                new MembersConnected.Connection("Peter", "Peter", seq++),
                new MembersConnected.Connection("John", "John", seq++),
                new MembersConnected.Connection("Cloe", "Cloe", seq++),
                new MembersConnected.Connection("Bia", "Bia", seq++),
                new MembersConnected.Connection("Mark", "Mark", seq++),
                new MembersConnected.Connection("Louis", "Louis", seq++),
                new MembersConnected.Connection("Mary", "Peter", seq++),
                new MembersConnected.Connection("Cloe", "Bia", seq++),
                new MembersConnected.Connection("Mark", "John", seq++),
                new MembersConnected.Connection("John", "Bia", seq++),
                new MembersConnected.Connection("Louis", "Mary", seq++),
                new MembersConnected.Connection("Peter", "Mark", seq++), // here 13
                new MembersConnected.Connection("Mary", "Mark", seq++),
                new MembersConnected.Connection("Louis", "Peter", seq++),
                new MembersConnected.Connection("Peter", "Cloe", seq++)
        );

        final MembersConnected mc = new MembersConnected(connections);
        System.out.println(mc);
        System.out.println(mc.toStringConnections());
        assertEquals(13, mc.allConnectedAtSequence());
    }

    @Test
    void test1000Members() {
        List<String[]> connections = FileUtils.getCSVLinesFromFileInTestResourcesFolder( ",", "algs4","members_connected.csv");
        connections.stream().map(Arrays::toString).forEach(System.out::println);
    }
}
