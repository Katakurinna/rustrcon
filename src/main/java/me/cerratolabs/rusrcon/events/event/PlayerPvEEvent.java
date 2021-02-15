package me.cerratolabs.rusrcon.events.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.nurio.events.handler.Event;

public class PlayerPvEEvent extends Event {

    private String killer;

    private String murdered;

    @JsonProperty("Time")
    private String time;

}