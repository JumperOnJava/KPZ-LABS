package org.example.task3;

import org.example.task3.renderer.RasterRenderer;
import org.example.task3.renderer.Renderer;
import org.example.task3.renderer.VectorRenderer;
import org.example.task3.shape.Circle;
import org.example.task3.shape.Shape;
import org.example.task3.shape.Square;
import org.example.task3.shape.Triangle;

import java.util.List;

public class Task3 {
    public static void Main() {
        Renderer raster = new RasterRenderer();
        Renderer vector = new VectorRenderer();

        List.of(raster, vector).forEach(renderer ->
        {
            Shape circle = new Circle(renderer);
            Shape square = new Square(renderer);
            Shape triangle = new Triangle(renderer);

            circle.draw();
            square.draw();
            triangle.draw();
        });
    }


}

