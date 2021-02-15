package me.cerratolabs.rusrcon.events.parser;

import lombok.AllArgsConstructor;
import me.cerratolabs.rusrcon.events.event.PlayerChatEvent;
import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rusrcon.events.parser.generic.IParser;

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