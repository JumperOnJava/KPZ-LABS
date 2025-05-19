package org.example.task5.button;

import org.example.task5.LightParentNode;
import org.example.task5.LightTextNode;
import org.example.task5.events.ClickEvent;

public class Button extends LightParentNode {
    private final Command action;

    public Button(String label, Command action) {
        super("button");
        this.action = action;
        addChild(new LightTextNode(label));
        onClick.subscribe(this::buttonClickEvent);
    }

    private void buttonClickEvent(ClickEvent clickEvent) {
        if(clickEvent.mousePressed() && clickEvent.button() == 0){
            action.execute();
        }
    }
}
