package me.cerratolabs.rustrcon.events.event.pve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rustrcon.entities.LivingEntity;
import me.cerratolabs.rustrcon.entities.MobEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
import me.nurio.events.handler.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobKilledByPlayerEvent extends Event {

    private MobEntity entity;

    private Player player;

    private Long time;
}