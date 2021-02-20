package me.cerratolabs.rustrcon.events.event.pve;

import lombok.Data;
import me.cerratolabs.rustrcon.entities.LivingEntity;
import me.cerratolabs.rustrcon.entities.MobEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
import me.nurio.events.handler.Event;

@Data
public class PlayerKillEntityEvent extends Event {

    private MobEntity entity;

    private Player player;

    private Long time;
}