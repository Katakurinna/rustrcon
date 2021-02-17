package me.cerratolabs.rustrcon.events.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rustrcon.entities.LivingEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDeathByEntityEvent extends PlayerDeathEvent {

    private LivingEntity entity;

    private Player player;

    private DeathReason reason;

    private Long time;

}