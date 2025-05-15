package org.example.task4;

import java.util.List;

public interface Reader {
    void open(String path);

    List<List<Character>> read();

    void close();
}
