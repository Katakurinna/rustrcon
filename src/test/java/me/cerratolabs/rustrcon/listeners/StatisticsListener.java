package me.cerratolabs.rustrcon.listeners;

import me.cerratolabs.rustrcon.entities.MobEntity;
import me.cerratolabs.rustrcon.events.event.PlayerDeathByEntityEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class StatisticsListener implements EventListener {

    @EventHandler
    public void wasKilledByMob(PlayerDeathByEntityEvent event) {
        MobEntity entity = (MobEntity) event.getEntity();
        System.out.println(event.getPlayer().getUsername() + " " + event.getReason() + " " + entity.getEntityName() + " " + entity.getEntityID());
    }
}