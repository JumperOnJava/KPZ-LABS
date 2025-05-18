package org.example.task1;

import java.io.IOException;
import java.io.InputStream;

public abstract class SupportScreen implements ChainHandler<InputStream> {
    private ChainHandler<InputStream> next;

    @Override
    public abstract void handle(InputStream input) throws IOException;

    protected void next(InputStream input) {
        if (next != null) {
            try {
                next.handle(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setNext(ChainHandler<InputStream> next) {
        this.next = next;
    }
}
