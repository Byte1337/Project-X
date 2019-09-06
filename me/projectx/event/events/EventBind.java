package me.projectx.event.events;

import me.projectx.event.Event;

public class EventBind extends Event {

    private int bind;

    public EventBind(int bind) {
        this.bind = bind;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
}
