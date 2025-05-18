package org.example.task5;

import java.io.IOException;
import java.util.List;

public class Task5 {
    public static void Main() throws IOException {
        var editor = new TextEditor(List.of(
                "Test document",
                "[INFO] Printing logs",
                "[WARN] Printing warnings",
                "[ERR] Printing errors"
        ));
        System.out.println("\n>>>[Document on open]<<<\n");
        editor.printDocument();

        editor.newLine("Test line 1; ");
        editor.addToLine(4, "Test line 2; ");
        System.out.println("\n>>>[Document after edits]<<<\n");
        editor.printDocument();
        editor.undo();
        System.out.println("\n>>>[Document after undo]<<<\n");
        editor.printDocument();
    }

}
