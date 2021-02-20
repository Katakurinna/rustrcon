package me.cerratolabs.rustrcon.events.parser.factory;

import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.parsers.PlayerChatEventParser;
import me.cerratolabs.rustrcon.events.parser.parsers.PlayerEventParser;
import me.cerratolabs.rustrcon.events.parser.parsers.PlayerKillEventParser;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.ArrayList;
import java.util.List;

public class RustParserFactory {

    private List<IParser> parsers;
    private List<IParser> parserIdentifier;

    public RustParserFactory() {
        parsers = new ArrayList<>();
        parserIdentifier = new ArrayList<>();
        parsers.add(new PlayerKillEventParser());
        parsers.add(new PlayerEventParser());
        parsers.add(new PlayerChatEventParser());
    }

    public Event getParser(RustGenericMessage message) {
        IParser parser = parsers.stream().filter(iParser -> iParser.match(message)).findFirst().orElse(null);
        if (parser == null) return null;
        return parser.toEvent(message);
    }

    /**
     * Rust messages contains a identifier, you can create custom events for differentes identifiers
     * Examples:
     * Sends a message with command <code>playerlist</code>.
     * Sets message identifier 44322
     * RCON response with same identifier
     * You receive the response from this list.
     * @param message
     * @return
     */
    public <T extends Event> Event getParserByIdentifier(RustGenericMessage message) {
        IParser parser = parserIdentifier.stream().filter(iParser -> iParser.match(message)).findFirst().orElse(null);
        if (parser == null) return null;
        return parser.toEvent(message);
    }

    public void registerParser(IParser parser) {
        parsers.add(parser);
    }

    public void registerParserByIdentifier(IParser parser) {
        parserIdentifier.add(parser);
    }

}