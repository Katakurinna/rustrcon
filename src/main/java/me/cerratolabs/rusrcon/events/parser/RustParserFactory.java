package me.cerratolabs.rusrcon.events.parser;

import me.nurio.events.handler.Event;

import java.util.List;

public class RustParserFactory {

    private List<IParser> parsers;

    public Event getParser(RustGenericMessage message) {
        return parsers.stream().filter(iParser -> iParser.match(message)).findFirst().orElseThrow().toEvent(message);
    }

}