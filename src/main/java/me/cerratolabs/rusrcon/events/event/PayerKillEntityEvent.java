package me.cerratolabs.rusrcon.events.event;

import lombok.Data;
import me.cerratolabs.rusrcon.entities.LivingEntity;
import me.cerratolabs.rusrcon.entities.Player;
import me.cerratolabs.rusrcon.entities.enums.DeathReason;

@Data
public class PayerKillEntityEvent {

    private LivingEntity entity;

    private Player player;

    private DeathReason reason;

    private Long time;
}