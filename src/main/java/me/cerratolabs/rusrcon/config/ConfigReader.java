package me.cerratolabs.rusrcon.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;

import java.io.File;

public class ConfigReader {

    private ServerConfig serverConfig;
    private final String fileName;
    private final ObjectMapper mapper;

    @SneakyThrows
    public ConfigReader(String fileName) {
        this.fileName = fileName;
        this.mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
    }

    @SneakyThrows
    public ServerConfig parse() {
        return mapper.readValue(new File(fileName), ServerConfig.class);
    }
}