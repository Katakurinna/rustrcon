package me.cerratolabs.rustrcon.entities.enums;

/**
 * Death reason
 * Never modify the ordinal, always add new ordinal in the end of the file.
 */
public enum DeathReason {
    KILLED_BY_PLAYER, // ordinal 0
    KILLED_BY_MOB, // ordinal 1
    COLD, // ordinal 2
    HUNGER, // ordinal 3
    DROWNED, // ordinal 4
    FALL, // ordinal 5
    GUNTRAP, // ordinal 6
    FLAMETURRET; // ordinal 7

    public static DeathReason getById(Integer id) {
        return values()[id];
    }

}