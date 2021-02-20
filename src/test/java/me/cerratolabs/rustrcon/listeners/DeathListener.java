package me.cerratolabs.rustrcon.listeners;

import me.cerratolabs.rustrcon.events.event.deaths.PlayerDeathEvent;
import me.cerratolabs.rustrcon.events.event.pve.PlayerKillEntityEvent;
import me.cerratolabs.rustrcon.events.event.pvp.PlayerDeathByPlayerEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class DeathListener implements EventListener {

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

    @EventHandler
    public void mobDeathByPlayer(PlayerKillEntityEvent event) {
        System.out.println(event.getPlayer().getUsername() + " ha matado al mob " + event.getEntity().getEntityName() + ":" + event.getEntity().getEntityID() + "");
        System.out.println(event);
    }
}
