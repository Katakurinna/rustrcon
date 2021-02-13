package me.cerratolabs.rusrcon.events.parser;

import me.nurio.events.handler.Event;

public class RustMessageParser {

    public Event parse(RustGenericMessage message) {
        if (message.getMessage().startsWith("[TEAM CHAT]")) {

        }
        return null;
    }

}