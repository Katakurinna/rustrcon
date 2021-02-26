package me.cerratolabs.rustrcon.tests.listeners;

import me.cerratolabs.rustrcon.events.event.pve.MobKilledByPlayerEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class PlayerKillEntityListener implements EventListener {

    @EventHandler
    public void payerKillEntity(MobKilledByPlayerEvent event) {
        System.out.println(event);
    }
}