package org.example.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SmartTextSecurity implements Reader {

    private final Reader target;

    public SmartTextSecurity(Reader reader) {
        this.target = reader;
    }

    @Override
    public void open(String path) {
        if(path.contains("system/")){
            throw new SecurityException("Tried to access system file");
        }
        target.open(path);
    }

    @Override
    public List<List<Character>> read() {
        return target.read();
    }

    @Override
    public void close() {
        target.close();
    }

}
