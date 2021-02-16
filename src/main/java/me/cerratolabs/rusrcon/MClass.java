package me.cerratolabs.rusrcon;

import me.cerratolabs.rusrcon.client.RustClient;
import me.cerratolabs.rusrcon.config.ConfigReader;
import me.cerratolabs.rusrcon.config.ServerConfig;
import me.cerratolabs.rusrcon.listeners.MessageListener;
import me.cerratolabs.rusrcon.listeners.StatisticsListener;
import me.nurio.events.EventManager;

public class MClass {

    private static final EventManager manager = new EventManager();
    private static RustClient rustClient;

    public static void main(String[] args) {
        ConfigReader reader = new ConfigReader("src\\main\\resources\\config.yml");
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