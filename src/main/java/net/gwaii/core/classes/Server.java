package net.gwaii.core.classes;

import net.gwaii.core.CoreModule;
import net.minestom.server.MinecraftServer;

public class Server {

    private static volatile Server serverInstance;
    private static boolean initialized;

    private Server() {}

    // Singleton design pattern: https://www.youtube.com/watch?v=tSZn4wkBIu8
    public static Server getServer() {
        var result = serverInstance;
        if (result == null) {
            synchronized (Server.class) {
                result = serverInstance;
                if (result == null) {
                    serverInstance = result = new Server();
                }
            }
        }
        return result;
    }

    public MinecraftServer initializeServer() {
        var server = MinecraftServer.init();

        // Module Registration
            // 1. Register dimensions
            // 2. Register biomes
            // 3. Register commands
            // 4. Register

        // Will switch to module::new when scaffolding if more flushed out.
        new CoreModule();

        return server;
    }

}
