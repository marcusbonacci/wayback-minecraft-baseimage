package net.gwaii.events;

import net.gwaii.config.ServerConfig;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.ping.Status;

import java.util.Map;
import java.util.function.Consumer;

public class _ServerListPingEvent implements Consumer<ServerListPingEvent> {

    private final Map<String, Object> config;

    public _ServerListPingEvent() {
        config = ServerConfig.getConfig();
    }

    // Getting a value from the config is Terrible, use an accessor
    // Should be able to do motd = config.get() without typecasting each time.

    @Override
    public void accept(ServerListPingEvent event) {

        var onlinePlayers = MinecraftServer.getConnectionManager().getOnlinePlayerCount();

        event.setStatus(Status.builder()
            .description(Component.text((String) config.get("SERVER_MOTD"), TextColor.color(120, 255, 120)))
            .playerInfo(Status.PlayerInfo.builder()
                .onlinePlayers(onlinePlayers)
                .maxPlayers((Integer) config.get("MAX_PLAYERS"))
                .build()
            )
            .build());
    }
}
