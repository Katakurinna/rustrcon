package me.cerratolabs.rustrcon.tests;

import me.cerratolabs.rustrcon.client.RustClient;
import me.cerratolabs.rustrcon.config.ConfigReader;
import me.cerratolabs.rustrcon.config.ServerConfig;
import me.cerratolabs.rustrcon.tests.listeners.PlayerDeathByEntityListener;
import me.cerratolabs.rustrcon.tests.listeners.PlayerKillEntityListener;
import me.nurio.events.EventManager;

public class MClass {

    private static final EventManager manager = new EventManager();
    private static RustClient rustClient;

    public static void main(String[] args) {
        ConfigReader reader = new ConfigReader("src/test/resources/config.yml");
        ServerConfig config = reader.parse();
        manager.registerEvents(new PlayerDeathByEntityListener());
        manager.registerEvents(new PlayerKillEntityListener());
        rustClient = new RustClient(manager);
        rustClient.startConnection(
            config.getAddress(),
            config.getPort(),
            config.getPassword()
        );
        new Thread(() -> {
            while (true) ;
        }).start();
    }
}