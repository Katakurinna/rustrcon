package me.cerratolabs.rusrcon.listeners;

import me.cerratolabs.rusrcon.events.MessageReceiveEvent;
import me.cerratolabs.rusrcon.events.PlayerChatEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class MessageListener implements EventListener {

    @EventHandler
    public void onAnything(MessageReceiveEvent event) {
        System.out.println(event.getData());
    }

    @EventHandler
    public void onMessage(PlayerChatEvent event) {
        System.out.println(event.getUsername() + ": " + event.getMessage());
    }
}