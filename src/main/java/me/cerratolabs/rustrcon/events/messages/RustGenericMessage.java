package me.cerratolabs.rustrcon.events.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RustGenericMessage {

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Identifier")
    private Integer identifier;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Stacktrace")
    private String stacktrace;

}