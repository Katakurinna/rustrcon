package me.cerratolabs.rustrcon.entities;

public interface LivingEntity {

    default boolean isPlayer() {
        return this instanceof Player;
    }

}