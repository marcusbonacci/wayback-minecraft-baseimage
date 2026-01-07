package net.gwaii.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ServerConfig {
    public final Map<String, Object> config;
    static ServerConfig configInstance = null;

    private ServerConfig() {
        config = new HashMap<>();
        loadConfig();
    }

    public static ServerConfig getConfig() {
        if (configInstance == null) {
            configInstance = new ServerConfig();
        }
        return configInstance;
    }

    // Config needs an accessor

    private void loadConfig() {
        config.put("SERVER_NAME", "My Server");
        config.put("SERVER_TYPE", "LOBBY");
        config.put("SERVER_ID", config.get("SERVER_TYPE") + "00001");
        config.put("SERVER_PORT", 25565);
        config.put("SERVER_MOTD", "Baseimage");

        config.putAll(System.getenv());
    }
}