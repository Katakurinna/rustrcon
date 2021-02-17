package me.cerratolabs.rustrcon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements LivingEntity {
    private String username;
    private String steamID;
}