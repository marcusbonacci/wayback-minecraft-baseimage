package net.gwaii;

import net.gwaii.events._AsyncPlayerConfigurationEvent;
import net.gwaii.events._PlayerSpawnEvent;
import net.minestom.server.Auth;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

public class Main {


    void main() {
        var server = initializeServer();

        server.start("0.0.0.0", 25565);
    }

    MinecraftServer initializeServer() {
        var server = MinecraftServer.init(new Auth.Online());

        var globalEventHandler = MinecraftServer.getGlobalEventHandler();
        var instanceManager = MinecraftServer.getInstanceManager();

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
