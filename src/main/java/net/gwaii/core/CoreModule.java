package net.gwaii.core;

import net.gwaii.core.events._AsyncPlayerConnectionEvent;
import net.gwaii.core.events._ServerListPingEvent;
import net.gwaii.core.interfaces.ServerModule;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.server.ServerListPingEvent;

public class CoreModule implements ServerModule {

    EventNode<Event> eventNode;
    GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

    public CoreModule() {
        eventNode = EventNode.all("core-module");
        initialize();
    }

    @Override
    public void initialize() {
        // Temporary, will make dynamic
        IO.println("[Module] Starting: CoreModule");

        eventNode.addListener(ServerListPingEvent.class, new _ServerListPingEvent());
        eventNode.addListener(AsyncPlayerConfigurationEvent.class, new _AsyncPlayerConnectionEvent());

        globalEventHandler.addChild(eventNode);
    }
}
