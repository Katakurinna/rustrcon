package me.cerratolabs.rusrcon.events.parser;

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