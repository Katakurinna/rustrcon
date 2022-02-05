package me.cerratolabs.rustrcon.tests.listeners;

import me.cerratolabs.rustrcon.events.event.pve.MobKilledByPlayerEvent;
import me.cerratolabs.rustrcon.events.event.pvp.PlayerDeathByPlayerEvent;
import me.cerratolabs.rustrcon.events.event.pvp.PlayerDeathEventsEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class PlayerKillEntityListener implements EventListener {

    @EventHandler
    public void playerKillEntity(MobKilledByPlayerEvent event) {
        System.out.println(event);
    }

    @EventHandler
    public void playerKillplayer(PlayerDeathEventsEvent event) {
        System.out.println(event);
    }
}