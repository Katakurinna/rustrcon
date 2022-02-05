package me.cerratolabs.rustrcon.tests.listeners;

import me.cerratolabs.rustrcon.events.event.chat.PlayerChatEvent;
import me.cerratolabs.rustrcon.events.event.pve.PlayerDeathByMobEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class PlayerDeathByEntityListener implements EventListener {

    @EventHandler
    public void playerDeathByEntity(PlayerDeathByMobEvent event) {
        System.out.println(event);
    }
}