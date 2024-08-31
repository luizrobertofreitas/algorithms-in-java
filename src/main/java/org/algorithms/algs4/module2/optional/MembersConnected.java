package org.algorithms.algs4.module2.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MembersConnected {

    private final String[] members;
    private final int[] connections;

    private final int connectedAtSequence;

    public MembersConnected(List<Connection> connections) {
        this.members = extractAllUniqueMembers(connections);
        this.connections = initConnections(this.members);
        this.connectedAtSequence = makeConnections(connections);
    }

    public int allConnectedAtSequence() {
        return connectedAtSequence;
    }

    @Override
    public String toString() {
        return Arrays.toString(members);
    }

    public String toStringConnections() {
        return Arrays.toString(connections);
    }

    private String[] extractAllUniqueMembers(List<Connection> connections) {
        Set<String> ms = connections.stream().map(Connection::friend1).collect(Collectors.toSet());
        ms.addAll(connections.stream().map(Connection::friend2).collect(Collectors.toSet()));
        return ms.toArray(String[]::new);
    }

    private int[] initConnections(String[] ms) {
        int[] conn = new int[ms.length];
        for (int i = 0; i < conn.length; i++) conn[i] = i;
        return conn;
    }

    private int makeConnections(List<Connection> connections) {
        for (Connection c : connections) {
            union(c.friend1, c.friend2);
            if (allConnected(c.friend1)) return c.sequence;
        }
        return -1;
    }

    private void union(String first, String second) {
        if (Objects.equals(first, second)) return;
        int firstRoot = findRoot(first);
        int secondRoot = findRoot(second);
        connections[firstRoot] = secondRoot;
    }

    private int findRoot(String m) {
        int mId = findMemberId(m);
        if (mId == -1) return mId;
        while (mId != connections[mId]) {
            connections[mId] = connections[connections[mId]];
            mId = connections[mId];
        }
        return mId;
    }

    private int findMemberId(String m) {
        for (int i = 0; i < members.length; i++) {
            if (Objects.equals(m, members[i])) return i;
        }
        return -1;
    }

    private boolean allConnected(String m) {
        for (String ms : members) {
            int firstRoot = findRoot(m);
            int secondRoot = findRoot(ms);
            if (firstRoot != secondRoot) return false;
        }
        return true;
    }

    public record Connection(String friend1, String friend2, int sequence) {}
}
