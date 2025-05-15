package org.example.task3.shape;

import org.example.task3.renderer.Renderer;

public class Circle extends Shape
{
    public Circle(Renderer renderer){
        super(renderer);
    }

    public void draw()
    {
        renderer.render("Circle");
    }
}
