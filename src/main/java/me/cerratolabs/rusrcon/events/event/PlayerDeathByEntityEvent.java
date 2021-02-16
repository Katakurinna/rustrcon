package me.cerratolabs.rusrcon.events.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rusrcon.entities.LivingEntity;
import me.cerratolabs.rusrcon.entities.Player;
import me.cerratolabs.rusrcon.entities.enums.DeathReason;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDeathByEntityEvent extends PlayerDeathEvent {

    private LivingEntity entity;

    private Player player;

    private DeathReason reason;

    private Long time;

}