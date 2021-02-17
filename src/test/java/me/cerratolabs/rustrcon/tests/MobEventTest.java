package me.cerratolabs.rustrcon.tests;

import me.cerratolabs.rustrcon.client.RustClient;
import me.cerratolabs.rustrcon.config.ConfigReader;
import me.cerratolabs.rustrcon.config.ServerConfig;
import me.cerratolabs.rustrcon.listeners.MessageListener;
import me.cerratolabs.rustrcon.listeners.StatisticsListener;
import me.nurio.events.EventManager;

public class MobEventTest {

    public void mockData() {
        EventManager manager = new EventManager();
        ConfigReader reader = new ConfigReader("src\\main\\test\\resources\\config.yml");
        ServerConfig config = reader.parse();
        manager.registerEvents(new MessageListener());
        manager.registerEvents(new StatisticsListener());
        RustClient rustClient = new RustClient(manager);
        rustClient.startConnection(
                config.getAddress(),
                config.getPort(),
                config.getPassword()
        );
    }
}
