package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasicImageDetect {

    public static String detect(String imagePath) {

        try {
            return URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(Files.readAllBytes(Paths.get(imagePath))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
