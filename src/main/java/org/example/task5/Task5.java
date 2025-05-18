package org.example.task5;

import org.example.task5.events.ClickEvent;
import org.example.task5.events.HoverEvent;
import org.example.task5.events.Subscriber;

import java.util.List;

public class Task5 {
    public static void Main() {
        var div = new LightElementNode("div");
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

    }
}
