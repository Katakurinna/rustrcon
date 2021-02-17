package me.cerratolabs.rustrcon.events.event;

import lombok.Data;
import me.cerratolabs.rustrcon.entities.LivingEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;

@Data
public class PayerKillEntityEvent {

    private LivingEntity entity;

    private Player player;

    private DeathReason reason;

    private Long time;
}