package org.example.task5;

import org.example.task5.button.Button;
import org.example.task5.button.DumpJsonCommand;
import org.example.task5.button.LogCommand;
import org.example.task5.events.ClickEvent;
import org.example.task5.events.HoverEvent;
import org.example.task5.events.Subscriber;
import org.example.task5.iframe.IFrameNode;
import org.example.task5.images.ImageContext;
import org.example.task5.images.ImageNode;
import org.example.task5.images.ImageServerStrategy;
import org.example.task5.images.CacheResolvingStrategy;
import org.example.task5.iterator.ClassIterator;
import org.example.task5.iterator.DFSIterator;
import org.example.task5.iterator.TagIterator;
import org.example.task5.visitor.FancyLoggerVisitor;
import org.example.task5.visitor.JsonLoggerVisitor;

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


        var closedTag = new LightTaggedNode("div");
        closedTag.addClass("generic-border");
        closedTag.addClass("shadow");

        var openTag = new LightParentNode("button");
        openTag.addClass("generic-border");
        openTag.addClass("shadow");
        openTag.addChild(text);
        openTag.addChild(div);

        System.out.println("[ClosedTag]");
        System.out.println(closedTag.outerHTML());
        System.out.println("[OpenTag]");
        System.out.println(openTag.outerHTML());

        var combinedTag = new LightParentNode("div");

        combinedTag.addChild(openTag);
        combinedTag.addChild(image);
        combinedTag.addChild(closedTag);
        combinedTag.addChild(new ImageNode("fox",imageContext));

        System.out.println();
        System.out.println();

        var shadowNodesIterator = new ClassIterator(combinedTag,"shadow");
        while (shadowNodesIterator.hasNext()) {
            var next = shadowNodesIterator.next();
            System.out.printf("[Shadow node]\n%s\n[Shadow node end]\n\n",next.outerHTML());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        var imageNodeIterator = new TagIterator(combinedTag,"image");
        while (imageNodeIterator.hasNext()) {
            var next = imageNodeIterator.next();
            System.out.printf("[Image node]\n%s\n[Image node end]\n\n",next.outerHTML());
        }

        var dfsIterator = new DFSIterator(combinedTag);
        while (dfsIterator.hasNext()) {
            var next = dfsIterator.next();
            System.out.printf("[DFS element]: %s\n",next.outerHTML());
        }


        try {
            var iframe = new IFrameNode(new URL("https://info.cern.ch/"));
            combinedTag.addChild(iframe);
            System.out.printf("[IFrame]: %s\n",iframe.outerHTML());
            System.out.printf("[Wait two seconds for fetching]\n");
            Thread.sleep(2000);
            System.out.printf("[IFrame]: %s\n",iframe.outerHTML());

            var iframeError = new IFrameNode(new URL("https://info.cernerror.ch/"));
            Thread.sleep(2000);
            System.out.printf("[IFrame Error]: %s\n",iframeError.outerHTML());
            //this method only used to set new correct url to demonstrate reloading functionality
            iframeError.demo_setUrl(new URL("https://info.cern.ch/"));
            iframeError.reload();
            System.out.printf("[IFrame reloading]: %s\n",iframeError.outerHTML());
            Thread.sleep(2000);
            System.out.printf("[IFrame reloaded]: %s\n",iframeError.outerHTML());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        combinedTag.accept(new FancyLoggerVisitor());
        var jsonVisitor = new JsonLoggerVisitor();
        combinedTag.accept(jsonVisitor);
        System.out.println(jsonVisitor.resultJson());




        var debugLogButton = new Button("Test button", new LogCommand("Hello, world!"));
        var saveButton = new Button("Save document", new DumpJsonCommand(combinedTag, "dump.json"));
        combinedTag.addChild(debugLogButton);
        combinedTag.addChild(saveButton);

        debugLogButton.onClick.publish(new ClickEvent(true,0,10,10));
        saveButton.onClick.publish(new ClickEvent(true,0,10,10));

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
