package com.kryvapust.graph;

import com.kryvapust.graph.files.MainFlow;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {
    private final MainFlow flow;

    public ApplicationEventListener(MainFlow flow) {
        this.flow = flow;
    }

    @EventListener
    public void handleContextStart(ApplicationStartedEvent event){
        flow.start();
    }
}
