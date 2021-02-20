package me.cerratolabs.rustrcon.events.parser.parsers;

import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.events.event.player.PlayerDisconnectEvent;
import me.cerratolabs.rustrcon.events.event.player.PlayerJoinEvent;
import me.cerratolabs.rustrcon.events.event.player.PlayerSpawnEvent;
import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerEventParser implements IParser<Event> {

    private final String PLAYER_SPAWNED = "((.+)(\\[(\\d{17})\\]))( has spawned)";
    private final String PLAYER_JOINS = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\:?([0-9]{1,5})\\/(\\d{17})\\/(.+)( joined )\\[(.+)\\/(\\d{17})\\]";
    private final String PLAYERS_DISCONNECT = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\:?([0-9]{1,5})\\/(\\d{17})\\/(.+)( disconnecting): (.+)";

    private final Pattern playerSpawnedPattern = Pattern.compile(PLAYER_SPAWNED, Pattern.MULTILINE);
    private final Pattern playerJoinsPattern = Pattern.compile(PLAYER_JOINS, Pattern.MULTILINE);
    private final Pattern playerDisconnectPattern = Pattern.compile(PLAYERS_DISCONNECT, Pattern.MULTILINE);

    @Override
    public boolean match(RustGenericMessage message) {
        if (playerJoinsPattern.matcher(message.getMessage()).matches()) {
            return true;
        }
        if (playerSpawnedPattern.matcher(message.getMessage()).matches()) {
            return true;
        }
        if (playerDisconnectPattern.matcher(message.getMessage()).matches()) {
            return true;
        }
        return false;
    }

    @Override
    public Event toEvent(RustGenericMessage message) {
        if (playerJoinsPattern.matcher(message.getMessage()).matches()) {
            return parsePlayersJoins(message);
        }
        if (playerSpawnedPattern.matcher(message.getMessage()).matches()) {
            return parsePlayerSpawnEvent(message);
        }
        if (playerDisconnectPattern.matcher(message.getMessage()).matches()) {
            return parsePlayerDisconnect(message);
        }
        return null;
    }

    private Event parsePlayersJoins(RustGenericMessage message) {
        Matcher matcher = playerJoinsPattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        String name = matcher.group(4);
        String steamID = matcher.group(3);
        long timestamp = System.currentTimeMillis();
        String so = matcher.group(6);
        String ip = matcher.group(1);
        return new PlayerJoinEvent(new Player(name, steamID), ip, so, timestamp);
    }

    private Event parsePlayerSpawnEvent(RustGenericMessage message) {
        Matcher matcher = playerSpawnedPattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        String name = matcher.group(2);
        String steamID = matcher.group(4);
        long timestamp = System.currentTimeMillis();
        return new PlayerSpawnEvent(new Player(name, steamID), timestamp);
    }

    private Event parsePlayerDisconnect(RustGenericMessage message) {
        Matcher matcher = playerDisconnectPattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        String name = matcher.group(4);
        String steamID = matcher.group(3);
        long timestamp = System.currentTimeMillis();
        String reason = matcher.group(6);
        String ip = matcher.group(1);
        return new PlayerDisconnectEvent(new Player(name, steamID), ip, reason, timestamp);
    }
}
