package org.example.task3.shape;

import org.example.task3.renderer.Renderer;

public abstract class Shape
{
    protected Renderer renderer;

    public Shape(Renderer renderer)
    {
        this.renderer = renderer;
    }

    public abstract void draw();
}
