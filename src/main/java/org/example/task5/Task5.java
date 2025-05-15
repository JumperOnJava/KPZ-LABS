package org.example.task5;

public class Task5 {
    public static void Main() {
        LightElementNode ul = new LightElementNode("ul");
        ul.addClass("my-list");

        LightElementNode li1 = new LightElementNode("li");
        li1.addChild(new LightTextNode("element 1"));

        LightElementNode li2 = new LightElementNode("li");
        li2.addChild(new LightTextNode("element 2"));

        ul.addChild(li1);
        ul.addChild(li2);

        System.out.println("=== outerHTML ===");
        System.out.println(ul.outerHTML());
        System.out.println("\n=== innerHTML ===");
        System.out.println(ul.innerHTML());
    }
}
