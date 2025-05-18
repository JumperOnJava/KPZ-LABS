package org.example.task1;

import java.io.IOException;

public interface ChainHandler<T>{
    void handle(T input) throws IOException;
    void setNext(ChainHandler<T> next);
}
