package net.gwaii;

import net.minestom.server.MinecraftServer;

public class Main {
    void main() {
        var serverManager = Server.getServer();

        var server = serverManager.initializeServer();

        server.start("0.0.0.0", 25565);
    }
}
