package org.example.task3.renderer;

public class VectorRenderer implements Renderer
{
    public void render(String shapeName)
    {
        System.out.printf("Drawing %s as lines%n", shapeName);
    }
}
