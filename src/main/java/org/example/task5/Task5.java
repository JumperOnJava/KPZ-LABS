package org.example.task5;

import org.example.task5.events.ClickEvent;
import org.example.task5.events.HoverEvent;
import org.example.task5.events.Subscriber;
import org.example.task5.images.ImageContext;
import org.example.task5.images.ImageNode;
import org.example.task5.images.ImageServerStrategy;
import org.example.task5.images.CacheResolvingStrategy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Task5 {
    public static void Main() {
        var div = new LightParentNode("div");
        var text = new LightTextNode("element 1");

        var subscriber = new Subscriber<ClickEvent>() {
            @Override
            public void run(ClickEvent event) {
                System.out.printf("%s button %s at %d %d\n", List.of("Left", "Right", "Middle").get(event.button()), event.mousePressed() ? "down" : "up", event.x(), event.y());
            }
        };
        div.onClick.subscribe(subscriber);
        div.onClick.publish(new ClickEvent(true, (int) (Math.random()*3), (int) (Math.random()*100), (int) (Math.random()*100)));



        //note: in java you can implement interface with lambda if it has only one method
        text.onHover.subscribe(event->{
            if(event.isOverElement()){
                System.out.printf("Hovered over text at %d %d\n", event.x(), event.y());
            }
        });

        text.onHover.publish(new HoverEvent(true,(int) (Math.random()*100), (int) (Math.random()*100)));


        var imageContext = new ImageContext();
        if(internetAvailable()) {
            imageContext.setResolvingStrategy(new ImageServerStrategy());
        }
        else {
            imageContext.setResolvingStrategy(new CacheResolvingStrategy());
        }

        var image = new ImageNode("frogs",imageContext);
        System.out.println(image.outerHTML());



    }

    private static boolean internetAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
}
