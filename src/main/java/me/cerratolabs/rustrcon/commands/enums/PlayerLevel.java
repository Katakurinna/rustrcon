package me.cerratolabs.rustrcon.commands.enums;

public enum PlayerLevel {

    EVERYONE,
    VIP,
    SUPER_VIP,
    MODERATOR,
    ADMIN,
    OWNER;

    public static PlayerLevel getById(Integer id) {
        return values()[id];
    }

}