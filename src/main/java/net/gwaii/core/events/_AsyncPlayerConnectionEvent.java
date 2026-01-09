package net.gwaii.core.events;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceManager;

import java.util.function.Consumer;

public class _AsyncPlayerConnectionEvent implements Consumer<AsyncPlayerConfigurationEvent> {

    private InstanceManager instanceManager;

    public _AsyncPlayerConnectionEvent() {
        this.instanceManager = MinecraftServer.getInstanceManager();
    }

    @Override
    public void accept(AsyncPlayerConfigurationEvent event) {
        var player = event.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.setRespawnPoint(new Pos(0, 64, 0));

//        event.setSpawningInstance();
    }
}
