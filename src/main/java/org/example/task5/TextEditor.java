package org.example.task5;

import java.util.List;
import java.util.Stack;


public class TextEditor {
    private TextDocument document;

    private Stack<TextDocument.Snapshot> undoStack = new Stack<>();

    public TextEditor(List<String> content) {
        this.document = new TextDocument(content);
    }

    void backup(){
        undoStack.add(document.backup());
    }

    void undo(){
        undoStack.pop().restore();
    }

    public void newLine(String line) {
        backup();
        document.lines.add(line);
    }

    public void addToLine(int index, String line) {
        backup();
        document.lines.set(index, document.lines.get(index) + line);
    }

    public void printDocument() {
        for(var string : document.lines){
            System.out.println(string);
        }
    }

}
