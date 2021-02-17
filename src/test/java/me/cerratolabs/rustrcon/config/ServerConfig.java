package me.cerratolabs.rustrcon.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerConfig {

    private String address;
    private Integer port;
    private String password;

}