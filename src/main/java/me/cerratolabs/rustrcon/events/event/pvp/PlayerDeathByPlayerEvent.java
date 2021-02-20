package me.cerratolabs.rustrcon.events.event.pvp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
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