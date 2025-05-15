package org.example.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.*;

public class SmartTextReader implements Reader {
    private BufferedReader reader;

    public SmartTextReader() {
    }

    @Override
    public void open(String filename) {
        filename = "src/main/java/org/example/task4/text/"+filename;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<List<Character>> read() {
        List<List<Character>> list = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Character> charList = new ArrayList<>();
                for (char ch : line.toCharArray()) {
                    charList.add(ch);
                }
                list.add(charList);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
