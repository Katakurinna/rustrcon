package me.cerratolabs.rustrcon.events.parser;

import me.cerratolabs.rustrcon.entities.MobEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
import me.cerratolabs.rustrcon.events.event.PlayerDeathByEntityEvent;
import me.cerratolabs.rustrcon.events.event.PlayerDeathByPlayerEvent;
import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerKillEventParser implements IParser<Event> {

    private static final String KILLED_BY_PLAYER_REGEX = "((.+)(\\[(\\d{17})\\]))( was killed by )((.+)(\\[(\\d{17})\\]))$";
    private static final String KILLED_BY_MOB_REGEX = "((.+)(\\[(\\d{17})\\]))( was killed by )((.+) (\\((\\d+)\\)))$";
    private static final String WAS_KILLED_BY = "was killed by";
    private static final String WAS_SUICIDE = "was suicide";

    private final Pattern playerPattern = Pattern.compile(KILLED_BY_PLAYER_REGEX, Pattern.MULTILINE);
    private final Pattern mobPattern = Pattern.compile(KILLED_BY_MOB_REGEX, Pattern.MULTILINE);

    @Override
    public boolean match(RustGenericMessage message) {
        return message.getMessage().contains(WAS_KILLED_BY) ||
            message.getMessage().contains(WAS_SUICIDE);
    }

    @Override
    public Event toEvent(RustGenericMessage message) {

        if (wasKilledByPlayer(message)) {
            return parseToDeathByPlayerEvent(message);
        }

        if (wasKilledByMob(message)) {
            return parseToDeathByEntityEvent(message);
        }

        return null;
    }

    private boolean wasKilledByPlayer(RustGenericMessage message) {
        String msg = message.getMessage();
        if (!msg.contains(WAS_KILLED_BY)) return false;
        Matcher matcher = playerPattern.matcher(message.getMessage());
        return matcher.matches();
    }

    private boolean wasSuicide(RustGenericMessage message) {
        String msg = message.getMessage();
        if (!msg.contains(WAS_SUICIDE)) return false;
        String replace = msg.substring(msg.indexOf(WAS_KILLED_BY)).replace(WAS_KILLED_BY, "").trim();
        String regex = "((.+)(\\((\\d+)\\)))$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = mobPattern.matcher(message.getMessage());
        return matcher.matches();
    }

    private boolean wasKilledByMob(RustGenericMessage message) {
        String msg = message.getMessage();
        if (!msg.contains(WAS_KILLED_BY)) return false;
        String replace = msg.substring(msg.indexOf(WAS_KILLED_BY)).replace(WAS_KILLED_BY, "").trim();
        String regex = "((.+) (\\((\\d+)\\)))$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(replace);
        return matcher.matches();
    }

    private PlayerDeathByEntityEvent parseToDeathByEntityEvent(RustGenericMessage message) {
        Matcher matcher = mobPattern.matcher(message.getMessage());
        if(!matcher.find()){
            System.out.println("No hago find bien");
            return null;
        }
        PlayerDeathByEntityEvent event = new PlayerDeathByEntityEvent();
        event.setEntity(new MobEntity(matcher.group(7), matcher.group(9)));
        event.setPlayer(new Player(matcher.group(2), matcher.group(4)));
        event.setTime(System.currentTimeMillis());
        event.setReason(DeathReason.KILLED_BY_MOB);
        return event;
    }

    private PlayerDeathByPlayerEvent parseToDeathByPlayerEvent(RustGenericMessage message) {
        System.out.println(message.getMessage());
        Matcher matcher = playerPattern.matcher(message.getMessage());
        if(!matcher.find()) return null;
        PlayerDeathByPlayerEvent event = new PlayerDeathByPlayerEvent();
        event.setPlayer(new Player(matcher.group(2), matcher.group(4)));
        event.setKiller(new Player(matcher.group(7), matcher.group(9)));
        event.setTime(System.currentTimeMillis());
        event.setReason(DeathReason.KILLED_BY_PLAYER);
        return event;
    }
}