package me.cerratolabs.rusrcon.events.parser.factory;

import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rusrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.List;

public class RustParserFactory {

    private List<IParser> parsers;

    public Event getParser(RustGenericMessage message) {
        return parsers.stream().filter(iParser -> iParser.match(message)).findFirst().orElseThrow().toEvent(message);
    }

}