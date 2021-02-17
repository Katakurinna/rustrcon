package me.cerratolabs.rustrcon.listeners;

import me.cerratolabs.rustrcon.events.event.PlayerDeathByPlayerEvent;
import me.cerratolabs.rustrcon.events.event.PlayerDeathEvent;
import me.cerratolabs.rustrcon.events.messages.MessageReceiveEvent;
import me.cerratolabs.rustrcon.events.event.PlayerChatEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class MessageListener implements EventListener {

    @EventHandler
    public void onAnything(MessageReceiveEvent event) {
        System.out.println(event.getData().getMessage());
    }

    @EventHandler
    public void onMessage(PlayerChatEvent event) {
        System.out.println(event.getUsername() + " " + event.getTime() + ": " + event.getMessage());
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent event) {
        System.out.println(event.getPlayer().getUsername() + " " + event.getReason() + "");
        System.out.println(event);
    }

    @EventHandler
    public void playerDeathByPlayer(PlayerDeathByPlayerEvent event) {
        System.out.println(event.getPlayer().getUsername() + " " + event.getReason() + "");
        System.out.println(event);
    }
}