package org.algorithms.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public final class FileUtils {

    public static final String TEST_RESOURCES_FOLDER_PATH = "src/test/resources";

    private FileUtils() {}

    public static List<String[]> getCSVLines(String csvDelimiter, String path, String ... csvFilePath) {
        try (Stream<String> lines = Files.lines(Paths.get(path, csvFilePath))) {
            return lines.map(line -> line.split(csvDelimiter)).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String[]> getCSVLinesFromFileInTestResourcesFolder(String csvDelimiter, String ... csvFilePath) {
        return getCSVLines(csvDelimiter, TEST_RESOURCES_FOLDER_PATH, csvFilePath);
    }

    public static List<String> getStreamOfLinesFromFile(final String filePath) {
        try (final Stream<String> lines = Files.lines(Paths.get(TEST_RESOURCES_FOLDER_PATH, filePath))) {
            return lines.toList();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
