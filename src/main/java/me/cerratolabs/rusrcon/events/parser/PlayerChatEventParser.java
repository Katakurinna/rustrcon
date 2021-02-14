package me.cerratolabs.rusrcon.events.parser;

import lombok.AllArgsConstructor;
import me.cerratolabs.rusrcon.events.PlayerChatEvent;

@AllArgsConstructor
public class PlayerChatEventParser implements IParser<PlayerChatEvent> {

    @Override
    public PlayerChatEvent toEvent(RustGenericMessage message) {
        PlayerChatEvent event = new PlayerChatEvent();
        //event.setChannel();
        return null;
    }

    @Override
    public boolean match(RustGenericMessage message) {
        return message.getMessage().startsWith("[TEAM CHAT]") || message.getMessage().startsWith("[CHAT]");
    }
}