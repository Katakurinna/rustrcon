package me.cerratolabs.rustrcon.events.parser.parsers;

import lombok.AllArgsConstructor;
import me.cerratolabs.rustrcon.events.event.chat.PlayerChatEvent;
import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;

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