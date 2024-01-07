package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

class BreadthFirstSearchTest {

    private final BreadthFirstSearch.Person penny = new BreadthFirstSearch.Person("penny", Collections.emptyList());
    private final BreadthFirstSearch.Person anuj = new BreadthFirstSearch.Person("anuj", List.of(penny));
    private final BreadthFirstSearch.Person peggy = new BreadthFirstSearch.Person("peggy", Collections.emptyList());
    private final BreadthFirstSearch.Person alice = new BreadthFirstSearch.Person("alice", List.of(peggy));
    private final BreadthFirstSearch.Person brian = new BreadthFirstSearch.Person("brian", Collections.emptyList());
    private final BreadthFirstSearch.Person jonny = new BreadthFirstSearch.Person("jonny", List.of(brian));
    private final BreadthFirstSearch.Person jafa = new BreadthFirstSearch.Person("jafa", Collections.emptyList());
    private final BreadthFirstSearch.Person thom = new BreadthFirstSearch.Person("thom", List.of(jafa));
    private final BreadthFirstSearch.Person bob = new BreadthFirstSearch.Person("bob", List.of(anuj, peggy));
    private final BreadthFirstSearch.Person claire = new BreadthFirstSearch.Person("claire", List.of(jonny, thom));
    private final BreadthFirstSearch.Person lizo = new BreadthFirstSearch.Person("lizo", List.of(bob, alice, claire));

    @ParameterizedTest
    @CsvSource({
            "a,1",
            "j,2",
            "b,1",
            "p,2",
            "c,1",
            "an,2",
            "jo,2",
            "ja,3",
            "pen,3"
    })
    void runShortestPathOnNameStartsWithLetter(String startsWith, Integer expectedDegreeResult) {
        Assertions.assertEquals(expectedDegreeResult, BreadthFirstSearch.SHORTEST_PATH_TO_NAME_STARTS_WITH.applyAsInt(lizo, startsWith));
    }

    @ParameterizedTest
    @CsvSource({
            "a,alice",
            "j,jonny",
            "b,bob",
            "p,peggy",
            "c,claire",
            "an,anuj",
            "jo,jonny",
            "ja,jafa",
            "pen,penny"
    })
    void runFirstThatNameStartsWith(String startsWith, String expectedName) {
        Assertions.assertEquals(expectedName, BreadthFirstSearch.FIRST_THAT_STARTS_WITH.apply(lizo, startsWith).name());
    }
}
