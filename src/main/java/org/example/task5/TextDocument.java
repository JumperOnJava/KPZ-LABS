package org.example.task5;

import java.util.ArrayList;
import java.util.List;

public class TextDocument {
    List<String> lines;
    public TextDocument(List<String> content) {
        lines = new ArrayList<>(content);
    }

    public Snapshot backup(){
        return new Snapshot(this, new ArrayList<>(lines));
    }

    private void restore(Snapshot snapshot) {
        this.lines = snapshot.lines;
    }

    public static class Snapshot {

        private final TextDocument document;
        private final List<String> lines;

        public Snapshot(TextDocument document, List<String> lines) {
            this.document = document;
            this.lines = lines;
        }

        public void restore(){
            this.document.restore(this);
        }
    }
}
