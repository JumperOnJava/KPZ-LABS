package org.example.task3.renderer;

public class RasterRenderer implements Renderer
{
    public void render(String shapeName)
    {
        System.out.printf("Drawing %s as pixels%n", shapeName);
    }
}
