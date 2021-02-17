package me.cerratolabs.rustrcon;

import me.cerratolabs.rustrcon.client.RustClient;
import me.cerratolabs.rustrcon.config.ConfigReader;
import me.cerratolabs.rustrcon.config.ServerConfig;
import me.cerratolabs.rustrcon.listeners.MessageListener;
import me.cerratolabs.rustrcon.listeners.StatisticsListener;
import me.nurio.events.EventManager;

public class MClass {

    private static final EventManager manager = new EventManager();
    private static RustClient rustClient;

    public static void main(String[] args) {
        ConfigReader reader = new ConfigReader("src\\main\\test\\resources\\config.yml");
        ServerConfig config = reader.parse();
        manager.registerEvents(new MessageListener());
        manager.registerEvents(new StatisticsListener());
        rustClient = new RustClient(manager);
        rustClient.startConnection(
                config.getAddress(),
                config.getPort(),
                config.getPassword()
        );
    }
}