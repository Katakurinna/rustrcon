package me.cerratolabs.rusrcon.commands.enums;

public enum PlayerLevel {


    EVERYONE(0),
    VIP(1),
    SUPER_VIP(2),
    MODERATOR(3),
    ADMIN(4),
    OWNER(5);

    private Integer id;

    private PlayerLevel(Integer id) {
        this.id = id;
    }

    public PlayerLevel getById(Integer id) {
        return values()[id];
    }

    public Integer getIdByEnum(PlayerLevel playerLevel){
        return playerLevel.id;
    }

}