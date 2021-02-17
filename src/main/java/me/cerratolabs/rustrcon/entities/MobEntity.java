package me.cerratolabs.rustrcon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobEntity implements LivingEntity {

    private String entityName;

    private String entityID;

}