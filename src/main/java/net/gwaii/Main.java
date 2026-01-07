package net.gwaii;

import net.gwaii.config.ServerConfig;
import net.gwaii.events._AsyncPlayerConfigurationEvent;
import net.gwaii.events._PlayerSpawnEvent;
import net.minestom.server.Auth;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;

import java.util.Map;
import java.util.Objects;

public class Main {

    private Map<String, Object> config;
    private Integer port;
    private String motd;

    void main() {
        var server = initializeServer();

        server.start("0.0.0.0", port);
    }

    MinecraftServer initializeServer() {
        var server = MinecraftServer.init(new Auth.Online());

        // Messy, fix with accessors and helpers
        config = ServerConfig.getConfig().config;
        port = (Integer) config.get("SERVER_PORT");
        motd = (String) config.get("SERVER_MOTD");

        var globalEventHandler = MinecraftServer.getGlobalEventHandler();

        var worldLoader = new WorldLoader();
        // Setup world repository
        var startingInstance = worldLoader.loadInstance("/worlds/world1");

        // Register Events / EventNodes
//        globalEventHandler.addChild(CoreEventNode);
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, new _AsyncPlayerConfigurationEvent(startingInstance));
        globalEventHandler.addListener(PlayerSpawnEvent.class, new _PlayerSpawnEvent(startingInstance));

        return server;
    }
}
