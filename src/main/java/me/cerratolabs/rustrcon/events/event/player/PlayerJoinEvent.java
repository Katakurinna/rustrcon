package me.cerratolabs.rustrcon.events.event.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rustrcon.entities.Player;
import me.nurio.events.handler.Event;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerJoinEvent extends Event {

    private Player player;

    private String ip;

    private String soSystem;

    private Long timestamp;
}
