package org.example;

import org.apache.tika.Tika;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TikaImageDetect {

    public static String detect(String imagePath) {

        try {
            return new Tika().detect(Files.readAllBytes(Paths.get(imagePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
