package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> imagePaths = getImagePathsFromResource("img");

        imagePaths.forEach(imagePath -> System.out.printf("Detecting using basic Java  - file type: %s%n",
            BasicImageDetect.detect(imagePath)));
        imagePaths.forEach(imagePath -> System.out.printf("Detecting using Apache Tika - file type: %s%n",
            BasicImageDetect.detect(imagePath)));
    }

    public static List<String> getImagePathsFromResource(String folder) throws IOException, URISyntaxException {
        List<String> imagePaths = new ArrayList<>();

        Path path = Paths.get(Objects.requireNonNull(Main.class.getClassLoader().getResource(folder)).toURI());

        Files.walk(path, 1)
            .filter(Files::isRegularFile) // Only files (not directories)
            .forEach(filePath -> imagePaths.add(filePath.toString()));

        return imagePaths;
    }
}