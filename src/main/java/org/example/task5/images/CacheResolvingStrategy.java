package org.example.task5.images;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CacheResolvingStrategy implements ImageResolvingStrategy {
    @Override
    public String getImage(String image) {
        try {
            return Files.readString(Paths.get("image_cache/"+image+".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
