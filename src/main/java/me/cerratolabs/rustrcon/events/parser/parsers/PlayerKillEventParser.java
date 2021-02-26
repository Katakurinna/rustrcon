package me.cerratolabs.rustrcon.events.parser.parsers;

import me.cerratolabs.rustrcon.entities.MobEntity;
import me.cerratolabs.rustrcon.entities.Player;
import me.cerratolabs.rustrcon.entities.enums.DeathReason;
import me.cerratolabs.rustrcon.events.event.pve.PlayerDeathByMobEvent;
import me.cerratolabs.rustrcon.events.event.pve.MobKilledByPlayerEvent;
import me.cerratolabs.rustrcon.events.event.pvp.PlayerDeathByPlayerEvent;
import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.generic.IParser;
import me.nurio.events.handler.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerKillEventParser implements IParser<Event> {

    private static final String KILLED_BY_PLAYER_REGEX = "((.+)(\\[(\\d{17})\\]))( was killed by )((.+)(\\[(\\d{17})\\]))$";
    private static final String PLAYER_KILLED_BY_MOB_REGEX = "((.+)(\\[(\\d{17})\\]))( was killed by )((.+)(\\[(\\d{0,16})\\]))$";
    private static final String MOB_KILLED_BY_PLAYER_REGEX = "((.+)(\\[(\\d{0,16})\\]))( was killed by )((.+)(\\[(\\d{17})\\]))$";
    private static final String PLAYER_KILLED_BY_ENTITY_REGEX = "((.+)(\\[(\\d{17})\\]))( was killed by )((.+) (\\((\\.+)\\)))$";
    private static final String MOB_KILLED_BY_ENTITYR_REGEX = "((.+) (\\((\\.+)\\)))( was killed by )((.+)(\\[(\\d{17})\\]))$";
    private static final String WAS_KILLED_BY = "was killed by";
    private static final String WAS_SUICIDE = "was suicide";

    private final Pattern playerPattern = Pattern.compile(KILLED_BY_PLAYER_REGEX, Pattern.MULTILINE);
    private final Pattern mobPattern = Pattern.compile(PLAYER_KILLED_BY_MOB_REGEX, Pattern.MULTILINE);

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
        if (playerWasKilledByMob(message)) {
            return parseToDeathByEntityEvent(message);
        }
        if (mobWasKilledByPlayer(message)) {
            return parseToMobDeathByPlayerEvent(message);
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

    private boolean playerWasKilledByMob(RustGenericMessage message) {
        String msg = message.getMessage();
        if (!msg.contains(WAS_KILLED_BY)) return false;
        Pattern mobPattern = Pattern.compile(PLAYER_KILLED_BY_MOB_REGEX, Pattern.MULTILINE);
        return mobPattern.matcher(msg).matches();
    }

    private boolean mobWasKilledByPlayer(RustGenericMessage message) {
        String msg = message.getMessage();
        if (!msg.contains(WAS_KILLED_BY)) return false;
        Pattern pattern = Pattern.compile(MOB_KILLED_BY_PLAYER_REGEX, Pattern.MULTILINE);
        return pattern.matcher(message.getMessage()).matches();
    }

    private PlayerDeathByMobEvent parseToDeathByEntityEvent(RustGenericMessage message) {
        Matcher matcher = mobPattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        PlayerDeathByMobEvent event = new PlayerDeathByMobEvent();
        event.setEntity(new MobEntity(matcher.group(7), matcher.group(9)));
        event.setPlayer(new Player(matcher.group(2), matcher.group(4)));
        event.setTime(System.currentTimeMillis());
        event.setReason(DeathReason.KILLED_BY_MOB);
        return event;
    }

    private MobKilledByPlayerEvent parseToMobDeathByPlayerEvent(RustGenericMessage message) {
        Pattern pattern = Pattern.compile(MOB_KILLED_BY_PLAYER_REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        MobKilledByPlayerEvent event = new MobKilledByPlayerEvent();
        event.setEntity(new MobEntity(matcher.group(2), matcher.group(4)));
        event.setPlayer(new Player(matcher.group(7), matcher.group(9)));
        event.setTime(System.currentTimeMillis());
        return event;
    }

    private PlayerDeathByPlayerEvent parseToDeathByPlayerEvent(RustGenericMessage message) {
        Matcher matcher = playerPattern.matcher(message.getMessage());
        if (!matcher.find()) return null;
        PlayerDeathByPlayerEvent event = new PlayerDeathByPlayerEvent();
        event.setPlayer(new Player(matcher.group(2), matcher.group(4)));
        event.setKiller(new Player(matcher.group(7), matcher.group(9)));
        event.setTime(System.currentTimeMillis());
        event.setReason(DeathReason.KILLED_BY_PLAYER);
        return event;
    }
}