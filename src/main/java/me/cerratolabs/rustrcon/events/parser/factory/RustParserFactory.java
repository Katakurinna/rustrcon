package me.cerratolabs.rustrcon.events.parser.factory;

import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.PlayerKillEventParser;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
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