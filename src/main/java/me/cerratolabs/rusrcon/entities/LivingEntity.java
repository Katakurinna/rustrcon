package me.cerratolabs.rusrcon.entities;

public interface LivingEntity {

    default boolean isPlayer() {
        return this instanceof Player;
    }

}