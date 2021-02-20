package me.cerratolabs.rustrcon.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements LivingEntity {

    @JsonProperty("username")
    private String username;

    @JsonProperty("steamID")
    private String steamID;
}