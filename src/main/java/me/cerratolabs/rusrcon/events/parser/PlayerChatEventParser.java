package me.cerratolabs.rusrcon.events.parser;

import lombok.AllArgsConstructor;
import me.cerratolabs.rusrcon.events.PlayerChatEvent;

@AllArgsConstructor
public class PlayerChatEventParser implements IParser<PlayerChatEvent> {

    private RustGenericMessage message;

    public PlayerChatEvent toEvent() {
        return null;
    }
}