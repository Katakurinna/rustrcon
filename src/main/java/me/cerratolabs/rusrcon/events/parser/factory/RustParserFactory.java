package me.cerratolabs.rusrcon.events.parser.factory;

import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rusrcon.events.parser.PlayerKillEventParser;
import me.cerratolabs.rusrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.ArrayList;
import java.util.List;

public class RustParserFactory {

    private List<IParser> parsers;

    public RustParserFactory() {
        parsers = new ArrayList<>();
        parsers.add(new PlayerKillEventParser());
    }

    public Event getParser(RustGenericMessage message) {
        IParser parser = parsers.stream().filter(iParser -> iParser.match(message)).findFirst().orElse(null);
        if (parser == null) return null;
        return parser.toEvent(message);
    }

}