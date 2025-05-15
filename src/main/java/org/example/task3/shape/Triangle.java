package org.example.task3.shape;

import org.example.task3.renderer.Renderer;

public class Triangle extends Shape
{
    public Triangle(Renderer renderer){
        super(renderer);
    }

    public void draw()
    {
        renderer.render("Triangle");
    }
}
