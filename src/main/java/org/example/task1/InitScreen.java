package org.example.task1;

import java.io.InputStream;

public class InitScreen extends SupportScreen {
    @Override
    public void handle(InputStream input) {
        new OptionSelection("Videogame support.\n Please check if your issue is amongst common issues:")
                .option("Error code 0x05D0", () -> {
                    System.out.println("This error happens if your path to game has cyrillic symbols. Move game folder to path without cyrilic symbols");
                })
                .option("Game crashing with V-Sync enabled", () -> {
                    System.out.println("This happens if you run game in on linux in windowed mode. Disable V-Sync in your DE or in game");
                })
                .option("\"Graphics driver error\" on start", () -> {
                    System.out.println("This happens if you use microsoft basic screen driver. Install driver specific to your GPU vendor");
                })
                .option("My issue is not here", () -> {
                    next(input);
                })
                .select(input);
    }
}
