package org.example.task1;

import java.io.InputStream;

public class TroubleshootScreen extends SupportScreen{
    @Override
    public void handle(InputStream input) {
        new OptionSelection(
                "" +
                        "Before contacting support, make sure you do these actions:\n" +
                        "\t Restart computer\n" +
                        "\t Verify game files trough steam\n" +
                        "\t Reinstall your operating system")
                .option("My issue is resolved",()->{System.out.println("Have a good day!");})
                .option("I did everything and my issue still persists", ()-> next(input))
                .select(input);
    }
}
