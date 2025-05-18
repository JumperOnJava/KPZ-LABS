package org.example.task5.images;

import java.util.Map;

public class ImageServerStrategy implements ImageResolvingStrategy {
    private String cat =
                    "      /\\_/\\\n" +
                    " /\\  / o o \\\n" +
                    "//\\\\ \\~(*)~/\n" +
                    "`  \\/   ^ /\n" +
                    "   | \\|| || \n" +
                    "   \\ '|| || \n" +
                    "    \\)()-())";

    private String frogs =
                    "              _         _\n" +
                    "  __   ___.--'_`.     .'_`--.___   __\n" +
                    " ( _`.'. -   'o` )   ( 'o`   - .`.'_ )\n" +
                    " _\\.'_'      _.-'     `-._      `_`./_\n" +
                    "( \\`. )    //\\`         '/\\\\    ( .'/ )\n" +
                    " \\_`-'`---'\\\\__,       ,__//`---'`-'_/\n" +
                    "  \\`        `-\\         /-'        '/\n" +
                    "   `                               ' ";

    private String fox =
                    " \n" +
                    "  _,-=._              /|_/|\n" +
                    "  `-.}   `=._,.-=-._.,  @ @._,\n" +
                    "     `._ _,-.   )      _,.-'\n" +
                    "        `    G.m-\"^m`m'     ";

    private Map<String, String> images = Map.of("cat", cat, "frogs", frogs, "fox", fox);

    public ImageServerStrategy() {}

    public String getImage(String image) {
        return images.getOrDefault(image,"");
    }
}
