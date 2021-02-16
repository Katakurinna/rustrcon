package me.cerratolabs.rusrcon.events.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rusrcon.entities.Player;
import me.cerratolabs.rusrcon.entities.enums.DeathReason;
import me.nurio.events.handler.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDeathByPlayerEvent extends Event {

    private Player killer;

    private Player player;

    private DeathReason reason;

    private Long time;
}