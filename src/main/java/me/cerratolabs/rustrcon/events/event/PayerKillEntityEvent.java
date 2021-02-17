package me.cerratolabs.rustrcon.events.event;

import lombok.Data;
import me.cerratolabs.rustrcon.entities.LivingEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
import me.nurio.events.handler.Event;

@Data
public class PayerKillEntityEvent extends Event {

    private LivingEntity entity;

    private Player player;

    private DeathReason reason;

    private Long time;
}