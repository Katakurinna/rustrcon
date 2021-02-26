package me.cerratolabs.rustrcon.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.cerratolabs.rustrcon.events.event.chat.PlayerChatEvent;
import me.cerratolabs.rustrcon.events.messages.MessageReceiveEvent;
import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.factory.RustParserFactory;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
import me.cerratolabs.rustrcon.websocket.ClientWebSocket;
import me.nurio.events.EventManager;
import me.nurio.events.handler.Event;

import java.net.URI;

@RequiredArgsConstructor
public class RustClient {
    private static final long SLEEP_RATE = 1000L;
    private ClientWebSocket clientWebSocket;
    private ObjectMapper mapper = new ObjectMapper();

    private final EventManager eventManager;
    private final RustParserFactory parserFactory = new RustParserFactory();

    @SneakyThrows
    public void startConnection(String address, String port, String password) {
        startConnection(new URI(String.format("ws://%s:%s/%s", address, port, password)));
    }

    @SneakyThrows
    public void startConnection(String address, int port, String password) {
        startConnection(new URI(String.format("ws://%s:%s/%s", address, port, password)));
    }

    @SneakyThrows
    public void startConnection(String url) {
        startConnection(new URI(url));
    }

    @SneakyThrows
    public void startConnection(URI uri) {
        clientWebSocket = new ClientWebSocket(uri);
        clientWebSocket.addMessageHandler(this::registerHandler);
    }

    @SneakyThrows
    public void registerHandler(String message) {
        RustGenericMessage rustGenericMessage = mapper.readValue(message, RustGenericMessage.class);
        Event event = getEvent(rustGenericMessage);
        //  new Thread(() -> eventManager.callEvent(new MessageReceiveEvent(rustGenericMessage))).start();
        if (event != null) {
            new Thread(() -> eventManager.callEvent(event)).start();
        }

    }

    @SneakyThrows
    public Event getEvent(RustGenericMessage message) {
        Event parser;
        if (message.getIdentifier() > 0) {
            parser = parserFactory.getParserByIdentifier(message);
            if (parser != null) return parser;
        }
        if (message.getType().equalsIgnoreCase("CHAT")) {
            return mapper.readValue(message.getMessage(), PlayerChatEvent.class);
        }
        parser = parserFactory.getParser(message);
        if (parser != null) return parser;

        return null;
    }

    @SneakyThrows
    public void sendChatMessage(String message) {
        RustGenericMessage rustGenericMessage = new RustGenericMessage();
        rustGenericMessage.setType("Chat");
        rustGenericMessage.setIdentifier(0);
        rustGenericMessage.setStacktrace("");
        rustGenericMessage.setMessage("say" + message);
        sendMessage(rustGenericMessage);
    }

    @SneakyThrows
    public void sendMessage(String message) {
        RustGenericMessage rustGenericMessage = new RustGenericMessage();
        rustGenericMessage.setType("Generic");
        rustGenericMessage.setIdentifier(0);
        rustGenericMessage.setStacktrace("");
        rustGenericMessage.setMessage(message);
        sendMessage(rustGenericMessage);
    }

    @SneakyThrows
    public void sendMessage(RustGenericMessage message) {
        clientWebSocket.sendMessage(mapper.writeValueAsString(message));
    }

    public boolean isOpen() {
        return clientWebSocket.isOpen();
    }

    public void registerEventParser(IParser parser) {
        this.parserFactory.registerParser(parser);
    }

    public void registerEventParserByIdentifier(IParser parser) {
        this.parserFactory.registerParserByIdentifier(parser);
    }
}