package org.example.task3.shape;

import org.example.task3.renderer.Renderer;

public class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }

    public void draw()
    {
        renderer.render("Square");
    }
}
