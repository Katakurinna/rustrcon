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
public class PlayerDeathEventsEvent extends Event {

    private Player player;

    private Player killer;

    private float distance;

    private boolean headshot;

    private String weapon;

    private Long time;

    private DeathReason reason;

}