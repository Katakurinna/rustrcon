package me.cerratolabs.rusrcon.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.cerratolabs.rusrcon.events.MessageReceiveEvent;
import me.cerratolabs.rusrcon.events.PlayerChatEvent;
import me.cerratolabs.rusrcon.events.parser.RustGenericMessage;
import me.cerratolabs.rusrcon.websocket.ClientWebSocket;
import me.nurio.events.EventManager;
import me.nurio.events.handler.Event;

import java.net.URI;

@RequiredArgsConstructor
public class RustClient {
    private static final long SLEEP_RATE = 1000L;
    private ClientWebSocket clientWebSocket;
    private ObjectMapper mapper = new ObjectMapper();

    private final EventManager eventManager;

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
        Thread.sleep(300);
        do {
            Thread.sleep(SLEEP_RATE);
        } while (clientWebSocket.isOpen());
    }

    @SneakyThrows
    public void registerHandler(String message) {
        RustGenericMessage rustGenericMessage = mapper.readValue(message, RustGenericMessage.class);
        Event event = getEvent(rustGenericMessage);
        eventManager.callEvent(event);
    }

    @SneakyThrows
    public Event getEvent(RustGenericMessage message) {
        if (message.getType().equalsIgnoreCase("CHAT")) {
            return mapper.readValue(message.getMessage(), PlayerChatEvent.class);
        }
        return new MessageReceiveEvent(message);
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
}