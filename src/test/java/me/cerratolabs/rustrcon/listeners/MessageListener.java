package me.cerratolabs.rustrcon.listeners;

import me.cerratolabs.rustrcon.events.event.pve.PlayerKillEntityEvent;
import me.cerratolabs.rustrcon.events.event.pvp.PlayerDeathByPlayerEvent;
import me.cerratolabs.rustrcon.events.event.deaths.PlayerDeathEvent;
import me.cerratolabs.rustrcon.events.messages.MessageReceiveEvent;
import me.cerratolabs.rustrcon.events.event.chat.PlayerChatEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class MessageListener implements EventListener {

    @EventHandler
    public void onAnything(MessageReceiveEvent event) {
        System.out.println("MESSAGE RECEIVE: " + event.getData().getMessage());
    }

    @EventHandler
    public void onMessage(PlayerChatEvent event) {
        System.out.println(event.getUsername() + " " + event.getTime() + ": " + event.getMessage());
    }

}