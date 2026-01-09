package net.gwaii.core.events;

import net.kyori.adventure.text.Component;
import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.ping.Status;

import java.util.function.Consumer;

public class _ServerListPingEvent implements Consumer<ServerListPingEvent> {
    @Override
    public void accept(ServerListPingEvent event) {
        var status = Status.builder()
            .playerInfo(Status.PlayerInfo.onlineCount())
            .description(Component.text("Hello, world!"))
            .build();
        event.setStatus(status);
    }
}
