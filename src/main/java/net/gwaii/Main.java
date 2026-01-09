package net.gwaii;

import net.gwaii.core.classes.Server;

public class Main {
    void main() {
        var serverManager = Server.getServer();

        var server = serverManager.initializeServer();

        server.start("0.0.0.0", 25565);
    }
}
