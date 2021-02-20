package me.cerratolabs.rustrcon.listeners;

import me.cerratolabs.rustrcon.events.event.player.PlayerDisconnectEvent;
import me.cerratolabs.rustrcon.events.event.player.PlayerJoinEvent;
import me.cerratolabs.rustrcon.events.event.player.PlayerSpawnEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class PlayerListener implements EventListener {

    @EventHandler
    public void playeJoins(PlayerJoinEvent event) {
        System.out.println(event.getPlayer() + " joins " + event.getIp() + " " + event.getSoSystem() + " " + event.getTimestamp());
    }

    @EventHandler
    public void playeDisconnect(PlayerDisconnectEvent event) {
        System.out.println(event.getPlayer() + " disconnect " + event.getReason() + " " + " " + event.getTimestamp());
    }

    @EventHandler
    public void playeSpawn(PlayerSpawnEvent event) {
        System.out.println(event.getPlayer() + " spawn " + event.getTimestamp());
    }
}