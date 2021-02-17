package me.cerratolabs.rustrcon.events.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.nurio.events.handler.Event;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerChatEvent extends Event {

    @JsonProperty("Channel")
    private String channel;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Color")
    private String color;

    @JsonProperty("Time")
    private String time;

}