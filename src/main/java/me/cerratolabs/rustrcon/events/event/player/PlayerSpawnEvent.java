package me.cerratolabs.rustrcon.events.event.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rustrcon.entities.Player;
import me.nurio.events.handler.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSpawnEvent extends Event {

    private Player player;

    private Long timestamp;
}
